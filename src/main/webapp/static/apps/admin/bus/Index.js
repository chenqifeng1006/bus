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
                            template:'<a class="edit button">编辑</a><a class="delete button">删除</a>'
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
                        $('.delete',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            console.log(item);
                        })
                    }
                })
            }
        });
    });
