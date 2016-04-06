define([
        'BasePage',
        'Util',
        'List',
        'text!../../../template/driver/line/infoTpl.html'
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
            				url:'line/getById',
            				data:{
            					id:busId
            				},
            				success:function(data){
            					that.lineItem = data;
            					that._loadMainPage()
            				}
            			})
            		}
            	})
            },
            _loadMainPage:function(){
                var that = this;
                that.pageContent({
                    parent:that.parent,
                    data:that.lineItem,
                    template:infoTpl
                });
                
            }
        });
    });
