<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
BackgroundTask backgroundTask = (BackgroundTask)request.getAttribute("backgroundTask");

BackgroundTaskStatus backgroundTaskStatus = BackgroundTaskStatusRegistryUtil.getBackgroundTaskStatus(backgroundTask.getBackgroundTaskId());
%>

<c:if test="<%= backgroundTaskStatus != null %>">

	<%
	long applicationDataCounter = GetterUtil.getLong(backgroundTaskStatus.getAttribute("applicationDataCounter"));
	long applicationDataTotal = GetterUtil.getLong(backgroundTaskStatus.getAttribute("applicationDataTotal"));

	int percentage = Math.round((float)applicationDataCounter / applicationDataTotal * 100);
	%>

	<clay:progressbar
		maxValue="<%= 100 %>"
		minValue="<%= 0 %>"
		value="<%= percentage %>"
	/>
</c:if>
