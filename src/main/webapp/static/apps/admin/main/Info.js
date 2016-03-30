define([
    'BasePage',
    'Util',
    'text!../../../template/admin/main/infoTpl.html'
],
function (BasePage,Util,infoTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            that.id = that.getCookie('admin_id');
            BasePage.fn.init.call(that, options);
        },
        initPage:function(){
            var that = this;
            that._loadMainPage();
        },
        _loadMainPage:function(){
            var that = this;
            that.ajax({
                url:'admin/getById',
                data:{
                    id:that.id
                },
                success:function(data){
                    that.adminData = that.pageContent({
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
                    url:'admin/update',
                    data:that.adminData,
                    success:function(data){
                        that.setCookie('admin_username',data.username)
                        require(['admin/main/Index'],function(Page){
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
