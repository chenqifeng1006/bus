define([
        'BasePage',
        'Util',
        'List',
        'text!../../../template/admin/notice/listTpl.html'
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
                require(['admin/notice/Add'],function(Page){
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
                            name:'时间',
                            width:'135',
                            fn:function(data){
                                return Util.formatDate(new Date(data.time),'YYYY-MM-DD hh:mm')
                            }
                        },
                        {
                            name:'内容',
                            index:'content'
                        },
                        {
                            name:'操作',
                            template:'<a class="edit button">编辑</a><a class="delete button">删除</a>'
                        }
                    ],
                    url:'notice/queryList',
                    data:{
                        startNum:0,
                        pageCount:10
                    },
                    bindEvent:function(){
                        $('.edit',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            require(['admin/notice/Edit'],function(Page){
                                new Page({
                                    parent:that.parent,
                                    item:item
                                }).initPage()
                            })
                        });
                        $('.delete',that.parent).click(function(e){
                            var item = that.list.getItemByEventTag(e);
                            if(confirm('确认删除么？')){
                                that.post({
                                    url:'notice/delete',
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
