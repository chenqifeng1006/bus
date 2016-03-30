define([
    'BasePage',
    'Util',
    'text!../../../template/admin/record/addTpl.html'
],
function (BasePage,Util,addTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            that.parent = options.parent;
            that.busId = options.busId;
            BasePage.fn.init.call(that, options);
        },
        initPage:function(){
            var that = this;
            that._loadMainPage();
        },
        _loadMainPage:function(){
            var that = this;
            that.recordItem = that.pageContent({
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
                    url:'record/add',
                    data:that.recordItem,
                    success:function(data){
                        require(['admin/record/Index'],function(Page){
                            new Page({
                                busId:that.busId,
                                parent:that.parent
                            }).initPage()
                        })
                    }
                })
            }
        }
    });
});