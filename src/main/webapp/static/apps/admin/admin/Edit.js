define([
    'BasePage',
    'Util',
    'text!../../../template/admin/admin/editTpl.html'
],
function (BasePage,Util,editTpl) {
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
                url:'admin/getById',
                data:{
                    id:that.id
                },
                success:function(data){
                    that.adminItem = that.pageContent({
                        parent:that.parent,
                        data:data,
                        template:editTpl,
                        methods:{
                            updateHandler: $.proxy(that._updateHandler,that)
                        }
                    });
                }
            });

        },
        _updateHandler:function(){
            var that = this;
            if(that.checkForm(that.parent)){
                that.post({
                    url:'admin/update',
                    data:that.adminItem,
                    success:function(data){
                        require(['admin/admin/Index'],function(Page){
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