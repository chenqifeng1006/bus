define([
    'BasePage',
    'Util',
    'text!../../../template/index/main/infoTpl.html'
],
function (BasePage,Util,infoTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            that.id = that.getCookie('user_id');
            BasePage.fn.init.call(that, options);
        },
        initPage:function(){
            var that = this;
            that._loadMainPage();
        },
        _loadMainPage:function(){
            var that = this;
            that.ajax({
                url:'user/getById',
                data:{
                    id:that.id
                },
                success:function(data){
                    that.userData = that.pageContent({
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
                    url:'user/update',
                    data:that.userData,
                    success:function(data){
                        that.setCookie('user_username',data.username)
                        require(['index/main/Index'],function(Page){
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
