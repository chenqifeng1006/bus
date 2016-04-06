define([
        'BasePage',
        'Util',
        'List',
        'text!../../../template/index/message/listTpl.html'
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
                require(['index/message/Add'],function(Page){
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
                            name:'用户名',
                            width:'75',
                            index:'username'
                        },
                        {
                            name:'时间',
                            width:'135',
                            fn:function(data){
                                return Util.formatDate(new Date(data.time),'YYYY-MM-DD hh:mm');
                            }
                        },
                        {
                            name:'内容',
                            index:'content'
                        }
                    ],
                    url:'message/queryList',
                    data:{
                        startNum:0,
                        pageCount:10
                    }
                })
            }
        });
    });