define([
        'BasePage',
        'Util',
        'text!../../../template/admin/bus/bindLineTpl.html'
    ],
    function (BasePage,Util,bindLineTpl) {
        return BasePage.extend({
            init:function(options){
                var that = this;
                that.parent = options.parent;
                that.id = options.item.id;
                BasePage.fn.init.call(that, options);
            },
            initPage:function(){
                var that = this;
                that._loadMainPage();
            },
            _loadMainPage:function(){
                var that = this;
                that.ajax({
                    url:'line/queryList',
                    success:function(data){
                        that.driverItem = that.pageContent({
                            parent:that.parent,
                            data:data,
                            template:bindLineTpl,
                            methods:{
                                bindHandler: $.proxy(that._bindHandler,that)
                            }
                        });
                    }
                });

            },
            _bindHandler:function(){
                var that = this;
                if(that.checkForm(that.parent)){
                    that.post({
                        url:'bus/bindLine',
                        data:{
                            id:that.id,
                            lineId:$('#lineId').val()
                        },
                        success:function(data){
                            require(['admin/bus/Index'],function(Page){
                                new Page({
                                    parent:that.parent
                                }).initPage()
                            })
                        }
                    })
                }
            }
        });
    });