define([
    'BasePage',
    'Util',
    'text!../../../template/admin/line/editTpl.html'
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
                url:'line/getById',
                data:{
                    id:that.id
                },
                success:function(data){
                    that.lineItem = that.pageContent({
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
                    url:'line/update',
                    data:that.lineItem,
                    success:function(data){
                        require(['admin/line/Index'],function(Page){
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