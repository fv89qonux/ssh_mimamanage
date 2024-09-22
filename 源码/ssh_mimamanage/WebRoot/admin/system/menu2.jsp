<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<dl id="menu-product">
	<dt>
		<i class="Hui-iconfont">&#xe620;</i> 个人资料<i
			class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
	</dt>
	<dd>
		<ul>
			<li><a
				data-href="${pageContext.request.contextPath}/initInfo.action"
				data-title="修改个人资料" href="javascript:void(0)">修改个人资料</a>
			</li>
			<li><a
				data-href="${pageContext.request.contextPath}/admin/User/updatepwd.jsp"
				data-title="修改密码" href="javascript:void(0)">修改密码</a>
			</li>
		</ul>
	</dd>
</dl>

<c:if test="${type == 'admin'}">
	<dl id="menu-product">
		<dt>
			<i class="Hui-iconfont">&#xe620;</i> 用户管理<i
				class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
		</dt>
		<dd>
			<ul>
				<li><a
					data-href="${pageContext.request.contextPath}/admin/User/saveOrUpdate.jsp"
					data-title="增加用户" href="javascript:void(0)">增加</a>
				</li>
				<li><a
					data-href="${pageContext.request.contextPath}/User-getAllUtil.action"
					data-title="查询用户" href="javascript:void(0)">查询</a>
				</li>
			</ul>
		</dd>
	</dl>
</c:if>

<dl id="menu-product">
	<dt>
		<i class="Hui-iconfont">&#xe620;</i>密码管理<i
			class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
	</dt>
	<dd>
		<ul>
			<c:if test="${type==type1||type==type2}">
				<li><a
					data-href="${pageContext.request.contextPath}/Mimamanage-initUtil.action"
					data-title="增加密码" href="javascript:void(0)">增加</a>
				</li>
			</c:if>
			<li><a
				data-href="${pageContext.request.contextPath}/Mimamanage-getAllUtil.action"
				data-title="查询密码" href="javascript:void(0)">查询</a>
			</li>
		</ul>
	</dd>
</dl>