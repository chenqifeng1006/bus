define([
        'BasePage',
        'Util',
        'List',
        'text!../../../template/admin/record/listTpl.html'
    ],
    function (BasePage,Util,List,listTpl) {
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
                require(['admin/record/Add'],function(Page){
                    new Page({
                        busId:that.busId,
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
                            name:'时间',
                            fn:function(data){
                                return Util.formatDate(new Date(data.time),'YYYY-MM-DD hh:mm')
                            }
                        },
                        {
                            name:'价格',
                            index:'price'
                        },
                        {
                            name:'操作',
                            template:'<a class="edit button">编辑</a>'
                        }
                    ],
                    url:'record/queryList',
                    data:{
                        filter:that.busId,
                        startNum:0,
                        pageCount:10
                    },
                    bindEvent:function(){
                        $('.edit',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            require(['admin/record/Edit'],function(Page){
                                new Page({
                                    busId:that.busId,
                                    parent:that.parent,
                                    item:item
                                }).initPage()
                            })
                        });
                    }
                })
            }
        });
    });
