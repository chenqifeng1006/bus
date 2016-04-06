define([
        'BasePage',
        'Util',
        'List',
        'text!../../../template/index/line/listTpl.html'
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
            _loadListPage:function(){
                var that = this;
                that.list = new List().init({
                    parent:$('#gridList',that.parent),
                    colModel:[
                        {
                            name:'线路名称',
                            index:'name'
                        },
                        {
                            name:'线路详情',
                            index:'allStationName'
                        }
                    ],
                    url:'line/queryList',
                    data:{
                        startNum:0,
                        pageCount:10
                    }
                })
            }
        });
    });
