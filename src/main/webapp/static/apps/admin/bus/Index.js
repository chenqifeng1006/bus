define([
        'BasePage',
        'Util',
        'List',
        'text!../../../template/admin/bus/listTpl.html'
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
                require(['admin/bus/Add'],function(Page){
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
                            name:'编号',
                            index:'busNo'
                        },
                        {
                            name:'车牌号',
                            index:'lisenceNo'
                        },
                        {
                            name:'荷载人数',
                            index:'maxPerson'
                        },
                        {
                            name:'驾驶人',
                            index:'driverName'
                        },
                        {
                            name:'行驶线路',
                            index:'lineName'
                        },
                        {
                            name:'操作',
                            fn:function(data){
                                var str = '<a class="recordDetail button">保养记录</a><a class="edit button">编辑</a><a class="delete button">删除</a>';
                                if(data.driverId){
                                    str = str + '<a class="unbindDriver button">驾驶人解绑</a>'
                                }else{
                                    str = str + '<a class="bindDriver button">驾驶人绑定</a>'
                                }
                                if(data.lineId){
                                    str = str + '<a class="unbindLine button">路线解绑</a>'
                                }else{
                                    str = str + '<a class="bindLine button">路线绑定</a>'
                                }
                                return str;
                            }
                        }
                    ],
                    url:'bus/queryList',
                    data:{
                        startNum:0,
                        pageCount:10
                    },
                    bindEvent:function(){
                        $('.edit',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            require(['admin/bus/Edit'],function(Page){
                                new Page({
                                    parent:that.parent,
                                    item:item
                                }).initPage()
                            })
                        });
                        $('.unbindDriver',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            if(confirm('确认解绑么？')){
                                that.post({
                                    url:'bus/unBindDriver',
                                    data:{
                                        id:item.id,
                                        driverId:item.driverId
                                    },
                                    success:function(){
                                        that.alert('解绑成功');
                                        that.list.reload();
                                    }
                                });
                            }
                        });
                        $('.unbindLine',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            if(confirm('确认解绑么？')){
                                that.post({
                                    url:'bus/unBindLine',
                                    data:{
                                        id:item.id,
                                        lineId:item.lineId
                                    },
                                    success:function(){
                                        that.alert('解绑成功');
                                        that.list.reload();
                                    }
                                });
                            }
                        });
                        $('.bindDriver',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            require(['admin/bus/BindDriver'],function(Page){
                                new Page({
                                    parent:that.parent,
                                    item:item
                                }).initPage()
                            })
                        });
                        $('.bindLine',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            require(['admin/bus/BindLine'],function(Page){
                                new Page({
                                    parent:that.parent,
                                    item:item
                                }).initPage()
                            })
                        });
                        $('.recordDetail',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            require(['admin/record/Index'],function(Page){
                                new Page({
                                    parent:that.parent,
                                    busId:item.id,
                                    item:item
                                }).initPage()
                            })
                        });
                        $('.delete',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            if(confirm('确认删除么？')){
                                that.post({
                                    url:'bus/delete',
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
