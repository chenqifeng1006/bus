define([
    'BasePage',
    'Util',
    'text!../../../template/admin/notice/addTpl.html'
],
function (BasePage,Util,addTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            that.parent = options.parent;
            BasePage.fn.init.call(that, options);
        },
        initPage:function(){
            var that = this;
            that._loadMainPage();
        },
        _loadMainPage:function(){
            var that = this;
            that.noticeItem = that.pageContent({
                parent:that.parent,
                template:addTpl,
                methods:{
                    addHandler: $.proxy(that._addHandler,that)
                }
            });

        },
        _addHandler:function(){
            var that = this;
            if(that.checkForm(that.parent)){
                that.post({
                    url:'notice/add',
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