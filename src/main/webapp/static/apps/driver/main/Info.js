define([
    'BasePage',
    'Util',
    'text!../../../template/driver/main/infoTpl.html'
],
function (BasePage,Util,infoTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            that.id = that.getCookie('driver_id');
            BasePage.fn.init.call(that, options);
        },
        initPage:function(){
            var that = this;
            that._loadMainPage();
        },
        _loadMainPage:function(){
            var that = this;
            that.ajax({
                url:'driver/getById',
                data:{
                    id:that.id
                },
                success:function(data){
                    that.driverData = that.pageContent({
                        parent:that.parent,
                        template:infoTpl,
                        data:data,
                        methods:{
                            updateHandler: $.proxy(that._updateHandler,that)
                        }
                    })
                }
            })
        },
        _updateHandler:function(){
            var that = this;
            if(that.checkForm(that.parent)){
                that.post({
                    url:'driver/update',
                    data:that.driverData,
                    success:function(data){
                        that.setCookie('driver_username',data.username)
                        require(['driver/main/Index'],function(Page){
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
