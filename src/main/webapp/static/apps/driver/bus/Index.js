define([
        'BasePage',
        'Util',
        'List',
        'text!../../../template/driver/bus/infoTpl.html'
    ],
    function (BasePage,Util,List,infoTpl) {
        return BasePage.extend({
            init:function(options){
                var that = this;
                that.parent = options.parent;
                that.driverId = that.getCookie('driver_id');
                BasePage.fn.init.call(that, options);
            },
            initPage:function(){
                var that = this;
                that._loadDriverInfo();
            },
            _loadDriverInfo:function(){
            	var that = this;
            	that.ajax({
            		url:'driver/getById',
            		data:{
            			id:that.driverId
            		},
            		success:function(data){
            			var busId = data.busId;
            			that.ajax({
            				url:'bus/getById',
            				data:{
            					id:busId
            				},
            				success:function(data){
            					that.busItem = data;
            					that._loadMainPage()
            				}
            			})
            			console.log(data);
            		}
            	})
            },
            _loadMainPage:function(){
                var that = this;
                that.pageContent({
                    parent:that.parent,
                    data:that.busItem,
                    template:infoTpl
                });
                
                $('#recordHandler').click(function(){
                	require(['driver/record/Index'],function(Page){
                		new Page({
                			parent:that.parent,
                			busId:that.busItem.id
                		}).initPage()
                	})
                	
                })
                
            },
            _recordHander:function(){
            	var that = this;
            	alert(22);
            },
            _loadListPage:function(){
                var that = this;
                that.list = new List().init({
                    parent:$('#gridList',that.parent),
                    colModel:[
                        {
                            name:'用户名',
                            index:'username'
                        },
                        {
                            name:'时间',
                            fn:function(data){
                                return Util.formatDate(new Date(data.time),'YYYY-MM-DD hh:mm');
                            }
                        },
                        {
                            name:'内容',
                            index:'content'
                        }
                    ],
                    url:'message/queryList',
                    data:{
                        startNum:0,
                        pageCount:10
                    }
                })
            }
        });
    });
