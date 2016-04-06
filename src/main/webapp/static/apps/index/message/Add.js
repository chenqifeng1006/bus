define([
    'BasePage',
    'Util',
    'text!../../../template/index/message/addTpl.html'
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
            that.messageItem = that.pageContent({
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
            	that.messageItem.$data.userId = that.getCookie('user_id');
            	debugger
                that.post({
                    url:'message/add',
                    data:that.messageItem,
                    success:function(data){
                        require(['index/message/Index'],function(Page){
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