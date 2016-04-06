define([
    'BasePage',
    'Util',
    'text!../../../template/driver/record/editTpl.html'
],
function (BasePage,Util,editTpl) {
    return BasePage.extend({
        init:function(options){
            var that = this;
            that.parent = options.parent;
            that.busId = options.busId;
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
                url:'record/getById',
                data:{
                    id:that.id
                },
                success:function(data){
                    data.time = new Date(data.time);
                    that.recordItem = that.pageContent({
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
                    url:'record/update',
                    data:that.recordItem,
                    success:function(data){
                        require(['driver/record/Index'],function(Page){
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