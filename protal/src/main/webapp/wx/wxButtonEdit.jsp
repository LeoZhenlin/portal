<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		/* $('#type').combobox({
		    onChange:function(newValue,oldValue){
				if (newValue == 'click') {
					$('#url').attr("disabled", "disabled");
					$('#key').attr("disabled", false);
				} 
				if (newValue = "view") {
					$('#key').attr("disabled", "disabled");
					$('#url').attr("disabled", false);
				}
		    }
		}); */
		$('#form').form({
			url : '${pageContext.request.contextPath}/wxbuttonController/edit',
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				return isValid;
			},
			success : function(result) {
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.success) {
					parent.$.modalDialog.openner_treeGrid.treegrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为resource.jsp页面预定义好了
					parent.layout_west_tree.tree('reload');
					parent.$.modalDialog.handler.dialog('close');
				}
			}
		});
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
		<form id="form" method="post">
			<input type="hidden" name="id" value="${wxButton.id }">
			<table class="table table-hover table-condensed">
				<tr>
					<th>菜单名称</th>
					<td><input name="name" type="text" placeholder="请输入菜单名称" class="easyui-validatebox span2" data-options="required:true" value="${wxButton.name}"></td>
					<th>按钮类型</th>
					<td>
						<select id="type" name="buttonType.id" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
							<c:forEach items="${typeList}" var="type">
								<option value="${type.id}" <c:if test="${wxButton.buttonType.id == type.id}">selected="selected"</c:if>>${type.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>上级菜单</th>
					<td>
						<select name="parent.id" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
							<option value="">--请选择--</option>
							<c:forEach items="${parentList}" var="button">
								<option value="${button.id}" <c:if test="${button.id == wxButton.parent.id}">selected="selected"</c:if>>${button.name}</option>
							</c:forEach>
						</select>
					</td>
					<th>排序</th>
					<td>
						<input name="seq" value="${wxButton.seq}" class="easyui-numberspinner" style="width: 140px; height: 29px;" required="required" data-options="editable:false,min:8">
					</td>
				</tr>
				<tr>
					<th>EventKey</th>
					<td><input id="key" name="key" type="text" placeholder="请输入EventKey" class="easyui-validatebox span2" value="${wxButton.key}"></td>
					<th>View URL</th>
					<td><input id="url" name="url" type="text" placeholder="请输入URL" class="easyui-validatebox span2" value="${wxButton.url}" /></td>
				</tr>
				<tr>
					<th>备注</th>
					<td colspan="3"><textarea name="remark" rows="" cols="" class="span5">${wxButton.remark}</textarea></td>
				</tr>
			</table>
		</form>
	</div>
</div>