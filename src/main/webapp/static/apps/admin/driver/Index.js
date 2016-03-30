define([
        'BasePage',
        'Util',
        'List',
        'text!../../../template/admin/driver/listTpl.html'
    ],
    function (BasePage,Util,List,listTpl) {
        return BasePage.extend({
            init:function(options){
                var that = this;
                that.parent = options.parent;
                BasePage.fn.init.call(that, options);
            },
            initPage:function(){
                var that = this;
                that._loadMainPage();
                that._loadListPage();
            },
            _loadMainPage:function(){
                var that = this;
                that.pageContent({
                    parent:that.parent,
                    template:listTpl,
                    methods:{
                        addHandler: $.proxy(that._addHandler,that)
                    }
                });
            },
            _addHandler:function(){
                var that = this;
                require(['admin/driver/Add'],function(Page){
                    new Page({
                        parent:that.parent
                    }).initPage()
                })
            },
            _loadListPage:function(){
                var that = this;
                that.list = new List().init({
                    parent:$('#gridList',that.parent),
                    colModel:[
                        {
                            name:'账号',
                            index:'loginId'
                        },
                        {
                            name:'驾驶人',
                            index:'username'
                        },
                        {
                            name:'电话',
                            index:'telephone'
                        },
                        {
                            name:'车牌号',
                            index:'lisenceno'
                        },
                        {
                            name:'操作',
                            fn:function(data){
                                if(data.busId){
                                    return '<a class="edit button">编辑</a><a class="delete button">删除</a><a class="unbindBus button">车辆解绑</a>'
                                }else{
                                    return '<a class="edit button">编辑</a><a class="delete button">删除</a><a class="bindBus button">车辆绑定</a>'
                                }
                            }
                        }
                    ],
                    url:'driver/queryList',
                    data:{
                        startNum:0,
                        pageCount:10
                    },
                    bindEvent:function(){
                        $('.edit',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            require(['admin/driver/Edit'],function(Page){
                                new Page({
                                    parent:that.parent,
                                    item:item
                                }).initPage()
                            })
                        });
                        $('.bindBus',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            require(['admin/driver/BindBus'],function(Page){
                                new Page({
                                    parent:that.parent,
                                    item:item
                                }).initPage()
                            })
                        });
                        $('.unbindBus',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            if(confirm('确认解绑么？')){
                                that.post({
                                    url:'driver/unBindBus',
                                    data:{
                                        id:item.id,
                                        busId:item.busId
                                    },
                                    success:function(){
                                        that.alert('解绑成功');
                                        that.list.reload();
                                    }
                                });
                            }
                        });
                        $('.delete',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            if(confirm('确认删除么？')){
                                that.post({
                                    url:'driver/delete',
                                    data:{
                                        id:item.id
                                    },
                                    success:function(){
                                        that.alert('删除成功');
                                        that.list.reload();
                                    }
                                });
                            }
                        })
                    }
                })
            }
        });
    });
