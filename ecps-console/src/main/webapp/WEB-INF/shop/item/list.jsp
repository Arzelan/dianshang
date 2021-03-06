<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/ecps/console/common/taglibs.jsp"%>
<head>
<title>商品录入及上下架管理_商品管理</title>
<meta name="heading" content="商品录入及上下架管理"/>
<meta name="menu" content="ItemMgmtMenu"/>
<script type="text/javascript" src="<c:url value='/${system}/res/js/jquery.form.js'/>"></script>
<script type="text/javascript" src="<c:url value='/${system}/res/js/jquery.tablesorter.js'/>"></script>
<script language="javascript" type="text/javascript">
    $(function(){
    	var showStatus = $("#showStatus").val();
    	if(showStatus == '0'){
    		$("#label5").attr("class","here");
    	}else if(showStatus == '1'){
    		$("#label4").attr("class","here");
    	}else{
    		$("#label6").attr("class","here");
    	}
    	
    	//获得到当前页码， 要转数值类型
    	var pageNo = parseInt($("#currentPageNo").val());
    	//获得总页数
    	var totalPage = parseInt($("#totalPage").val());
    	if(totalPage == 1){
    		$("#previous").hide();
    		$("#next").hide();
    	}else if(totalPage > 1 && pageNo == 1){
    		$("#previous").hide();
    		$("#next").show();
    	}else if(pageNo > 1 && pageNo < totalPage){
    		$("#previous").show();
    		$("#next").show();
    	}else if(totalPage == pageNo && totalPage > 1){
    		$("#previous").show();
    		$("#next").hide();
    	}
    	//点击下一页
    	$("#next").click(function(){
    		$("#pageNo").val(pageNo + 1);
    		$("#form1").submit();
    	});
    	//上一页
    	$("#previous").click(function(){
    		$("#pageNo").val(pageNo - 1);
    		$("#form1").submit();
    	});
    	//首页
    	$("#firstPage").click(function(){
    		$("#pageNo").val(1);
    		$("#form1").submit();
    	});
    	//尾页
    	$("#lastPage").click(function(){
    		$("#pageNo").val(totalPage);
    		$("#form1").submit();
    	});
    	
    	$("#selectPage").change(function(){
    		var pageNo = $(this).val();
    		$("#pageNo").val(pageNo);
    		$("#form1").submit();
    	})
    })
</script>
</head>
<body id="main">

<div class="frameL"><div class="menu icon">
    <jsp:include page="/${system}/common/itemmenu.jsp"/>
</div></div>

<div class="frameR"><div class="content">

    <div class="loc icon"><samp class="t12"></samp>当前位置：商品管理&nbsp;&raquo;&nbsp;<span class="gray" title="商品录入及上下架">商品录入及上下架</span></div>

    <h2 class="h2_ch"><span id="tabs" class="l">
        <a id="label6" href="${path}/item/selectItemByCondition.do"   title="全部实体商品" class="nor">全部</a>
        <a id="label4" href="${path}/item/selectItemByCondition.do?showStatus=1"   title="未上架实体商品" class="nor">未上架</a>
        <a id="label5" href="${path}/item/selectItemByCondition.do?showStatus=0"  title="已上架实体商品" class="nor">已上架</a>
    </span></h2>

<form id="form1" name="form1" action="${path}/item/selectItemByCondition.do" method="post">
    <input type="hidden" id="showStatus" name="showStatus" value="${showStatus}" />
    <div class="sch">
        <input type="hidden" id="userSearch" name="userSearch" />
        <p>搜索：
       	<select name="brandId">
       		<option value="">请选择品牌</option>
       		<c:forEach items="${bList }" var="brand">
       			<option value="${brand.brandId }" <c:if test="${brand.brandId == brandId }">selected</c:if> >${brand.brandName }</option>
       		</c:forEach>
       	</select>
       	<select name="auditStatus">
       		<option value="">请选择审核状态</option>
       		<option value="0" <c:if test="${auditStatus == 0 }">selected</c:if>>待审核</option>
       		<option value="1" <c:if test="${auditStatus == 1 }">selected</c:if>>通过</option>
       		<option value="2" <c:if test="${auditStatus == 2 }">selected</c:if>>不通过</option>
       	</select>
        <input type="text" id="searchText" value="${itemName }" name="itemName" title="请输入商品名称" class="text20 medium gray" />
        <input type="submit" id="goSearch" class="hand btn60x20" value="查询" />
    </p></div>

    <div class="page_c">
        <span class="l">
        </span>
        <span class="r inb_a">
            <a href="${path}/item/toAddItem.do" class="btn80x20" title="添加商品">添加商品</a>
        </span>
    </div>

	<table cellspacing="0" summary="" class="tab" id="myTable">
		<thead>
			<th>商品编号</th>
            <th class="wp">商品名称</th>
            <th>图片</th>
			<th>新品</th>
			<th>推荐</th>
			<th>特价</th>
            <th>上下架</th>
            <th>审核状态</th>
			<th>操作</th>
		</thead>
		<tbody>
		<c:forEach items="${page.list }" var="item">
			<tr>
				<td>${item.itemNo }</td>
                <td >${item.itemName }</td>
                <td><img alt="" src="" width="50" height="50"></td>
				
				<td>
					<c:if test="${item.isNew == 1 }"><span class="is" ></span></c:if>
					<c:if test="${item.isNew == 0 }"><span class="not" ></span></c:if>
				</td>
				<td>
					
					<c:if test="${item.isGood == 1 }"><span class="is" ></span></c:if>
					<c:if test="${item.isGood == 0 }"><span class="not" ></span></c:if>
				</td>
				<td>
					<c:if test="${item.isHot == 1 }"><span class="is" ></span></c:if>
					<c:if test="${item.isHot == 0 }"><span class="not" ></span></c:if>
					
				</td>
                <td>
                	<c:if test="${item.showStatus == 0 }"><span class="is" ></span></c:if>
					<c:if test="${item.showStatus == 1 }"><span class="not" ></span></c:if>
					
                </td>
                <td>
                	
					<c:if test="${item.auditStatus == 0 }">待审核</c:if>
					<c:if test="${item.auditStatus == 1 }">通过</c:if>
					<c:if test="${item.auditStatus == 2 }">不通过</c:if>
					
                </td>
               
				<td>
							<a href="/ecps-console/shop/item/viewItem.jsp" title="查看">查看</a>
					  	
					  		
					  		
					  			<a href="/ecps-console/ecps/console/item/editItem.do?type=1&itemId=2384">编辑</a>
					  			<a href="javascript:void(0);" onclick="singleDel('2384')">删除</a>
					  			<a href="javascript:void(0);" group="2384,0" itemId=3184 showStatus="0">上架</a>
					  		
					  		
					  			
					  			
				</td>
			</tr>
		</c:forEach>
		
		
			
	</table>
    
	<div class="page_c">
        <span class="l inb_a">
        </span>
        <span class="r page">
            <input type="hidden" value="" id="pageNo" name="pageNo" />
            <input type="hidden" value="${page.totalCount}" id="totalCount" name="totalCount" />
            <input type="hidden" value="${page.pageNo}" id="currentPageNo" name="currentPageNo" />
            <input type="hidden" value="${page.totalPage}" id="totalPage" name="totalPage" />
                    共<var id="pagePiece" class="orange">${page.totalCount}</var>条<var id="pageTotal">${page.pageNo}/${page.totalPage}</var>
             <a href="javascript:void(0);" id="firstPage"  title="首页">首页</a>
            <a href="javascript:void(0);" id="previous" class="hidden" title="上一页">上一页</a>
            <a href="javascript:void(0);" id="next" class="hidden" title="下一页">下一页</a>
            <select id="selectPage">
            	<c:forEach begin="1" end="${page.totalPage }" var="pageNo" >
            		<option value="${pageNo }" <c:if test="${pageNo == page.pageNo }">selected</c:if> >${pageNo }</option>
            	</c:forEach>
            </select>
            <a href="javascript:void(0);" id="lastPage"  title="下一页">尾页</a>
        </span>
    </div>
</form>
</div></div>
</body>