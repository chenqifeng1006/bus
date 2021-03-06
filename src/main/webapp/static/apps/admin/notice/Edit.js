define([
    'BasePage',
    'Util',
    'text!../../../template/admin/notice/editTpl.html'
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
                url:'notice/getById',
                data:{
                    id:that.id
                },
                success:function(data){
                    data.time = new Date(data.time);
                    that.noticeItem = that.pageContent({
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
                    url:'notice/update',
                    data:that.noticeItem,
                    success:function(data){
                        require(['admin/notice/Index'],function(Page){
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