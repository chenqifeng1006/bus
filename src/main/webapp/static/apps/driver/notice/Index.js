define([
        'BasePage',
        'Util',
        'List',
        'text!../../../template/driver/notice/listTpl.html'
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
                    }
                });
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
                        }
                    ],
                    url:'notice/queryList',
                    data:{
                        startNum:0,
                        pageCount:10
                    }
                })
            }
        });
    });
