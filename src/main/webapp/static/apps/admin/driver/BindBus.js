define([
        'BasePage',
        'Util',
        'text!../../../template/admin/driver/bindBusTpl.html'
    ],
    function (BasePage,Util,bindBusTpl) {
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
                    url:'bus/queryNoDriverList',
                    success:function(data){
                        that.driverItem = that.pageContent({
                            parent:that.parent,
                            data:data,
                            template:bindBusTpl,
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
                        url:'driver/bindBus',
                        data:{
                            id:that.id,
                            busId:$('#busId').val()
                        },
                        success:function(data){
                            require(['admin/driver/Index'],function(Page){
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