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

package com.liferay.portal.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.UserGroupGroupRole;
import com.liferay.portal.kernel.model.UserGroupGroupRoleModel;
import com.liferay.portal.kernel.model.UserGroupGroupRoleSoap;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.persistence.UserGroupGroupRolePK;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the UserGroupGroupRole service. Represents a row in the &quot;UserGroupGroupRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link UserGroupGroupRoleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserGroupGroupRoleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupGroupRoleImpl
 * @see UserGroupGroupRole
 * @see UserGroupGroupRoleModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class UserGroupGroupRoleModelImpl extends BaseModelImpl<UserGroupGroupRole>
	implements UserGroupGroupRoleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user group group role model instance should use the {@link UserGroupGroupRole} interface instead.
	 */
	public static final String TABLE_NAME = "UserGroupGroupRole";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "userGroupId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "roleId", Types.BIGINT },
			{ "companyId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("roleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table UserGroupGroupRole (mvccVersion LONG default 0 not null,userGroupId LONG not null,groupId LONG not null,roleId LONG not null,companyId LONG,primary key (userGroupId, groupId, roleId))";
	public static final String TABLE_SQL_DROP = "drop table UserGroupGroupRole";
	public static final String ORDER_BY_JPQL = " ORDER BY userGroupGroupRole.id.userGroupId ASC, userGroupGroupRole.id.groupId ASC, userGroupGroupRole.id.roleId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY UserGroupGroupRole.userGroupId ASC, UserGroupGroupRole.groupId ASC, UserGroupGroupRole.roleId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.UserGroupGroupRole"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.UserGroupGroupRole"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.UserGroupGroupRole"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long ROLEID_COLUMN_BITMASK = 2L;
	public static final long USERGROUPID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserGroupGroupRole toModel(UserGroupGroupRoleSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UserGroupGroupRole model = new UserGroupGroupRoleImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUserGroupId(soapModel.getUserGroupId());
		model.setGroupId(soapModel.getGroupId());
		model.setRoleId(soapModel.getRoleId());
		model.setCompanyId(soapModel.getCompanyId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserGroupGroupRole> toModels(
		UserGroupGroupRoleSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UserGroupGroupRole> models = new ArrayList<UserGroupGroupRole>(soapModels.length);

		for (UserGroupGroupRoleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.kernel.model.UserGroupGroupRole"));

	public UserGroupGroupRoleModelImpl() {
	}

	@Override
	public UserGroupGroupRolePK getPrimaryKey() {
		return new UserGroupGroupRolePK(_userGroupId, _groupId, _roleId);
	}

	@Override
	public void setPrimaryKey(UserGroupGroupRolePK primaryKey) {
		setUserGroupId(primaryKey.userGroupId);
		setGroupId(primaryKey.groupId);
		setRoleId(primaryKey.roleId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UserGroupGroupRolePK(_userGroupId, _groupId, _roleId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UserGroupGroupRolePK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return UserGroupGroupRole.class;
	}

	@Override
	public String getModelClassName() {
		return UserGroupGroupRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("userGroupId", getUserGroupId());
		attributes.put("groupId", getGroupId());
		attributes.put("roleId", getRoleId());
		attributes.put("companyId", getCompanyId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long userGroupId = (Long)attributes.get("userGroupId");

		if (userGroupId != null) {
			setUserGroupId(userGroupId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getUserGroupId() {
		return _userGroupId;
	}

	@Override
	public void setUserGroupId(long userGroupId) {
		_columnBitmask |= USERGROUPID_COLUMN_BITMASK;

		if (!_setOriginalUserGroupId) {
			_setOriginalUserGroupId = true;

			_originalUserGroupId = _userGroupId;
		}

		_userGroupId = userGroupId;
	}

	public long getOriginalUserGroupId() {
		return _originalUserGroupId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_columnBitmask |= ROLEID_COLUMN_BITMASK;

		if (!_setOriginalRoleId) {
			_setOriginalRoleId = true;

			_originalRoleId = _roleId;
		}

		_roleId = roleId;
	}

	public long getOriginalRoleId() {
		return _originalRoleId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public UserGroupGroupRole toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserGroupGroupRole)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserGroupGroupRoleImpl userGroupGroupRoleImpl = new UserGroupGroupRoleImpl();

		userGroupGroupRoleImpl.setMvccVersion(getMvccVersion());
		userGroupGroupRoleImpl.setUserGroupId(getUserGroupId());
		userGroupGroupRoleImpl.setGroupId(getGroupId());
		userGroupGroupRoleImpl.setRoleId(getRoleId());
		userGroupGroupRoleImpl.setCompanyId(getCompanyId());

		userGroupGroupRoleImpl.resetOriginalValues();

		return userGroupGroupRoleImpl;
	}

	@Override
	public int compareTo(UserGroupGroupRole userGroupGroupRole) {
		UserGroupGroupRolePK primaryKey = userGroupGroupRole.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserGroupGroupRole)) {
			return false;
		}

		UserGroupGroupRole userGroupGroupRole = (UserGroupGroupRole)obj;

		UserGroupGroupRolePK primaryKey = userGroupGroupRole.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		UserGroupGroupRoleModelImpl userGroupGroupRoleModelImpl = this;

		userGroupGroupRoleModelImpl._originalUserGroupId = userGroupGroupRoleModelImpl._userGroupId;

		userGroupGroupRoleModelImpl._setOriginalUserGroupId = false;

		userGroupGroupRoleModelImpl._originalGroupId = userGroupGroupRoleModelImpl._groupId;

		userGroupGroupRoleModelImpl._setOriginalGroupId = false;

		userGroupGroupRoleModelImpl._originalRoleId = userGroupGroupRoleModelImpl._roleId;

		userGroupGroupRoleModelImpl._setOriginalRoleId = false;

		userGroupGroupRoleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserGroupGroupRole> toCacheModel() {
		UserGroupGroupRoleCacheModel userGroupGroupRoleCacheModel = new UserGroupGroupRoleCacheModel();

		userGroupGroupRoleCacheModel.userGroupGroupRolePK = getPrimaryKey();

		userGroupGroupRoleCacheModel.mvccVersion = getMvccVersion();

		userGroupGroupRoleCacheModel.userGroupId = getUserGroupId();

		userGroupGroupRoleCacheModel.groupId = getGroupId();

		userGroupGroupRoleCacheModel.roleId = getRoleId();

		userGroupGroupRoleCacheModel.companyId = getCompanyId();

		return userGroupGroupRoleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{mvccVersion=");
		sb.append(getMvccVersion());
		sb.append(", userGroupId=");
		sb.append(getUserGroupId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.kernel.model.UserGroupGroupRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mvccVersion</column-name><column-value><![CDATA[");
		sb.append(getMvccVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userGroupId</column-name><column-value><![CDATA[");
		sb.append(getUserGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = UserGroupGroupRole.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			UserGroupGroupRole.class, ModelWrapper.class
		};
	private long _mvccVersion;
	private long _userGroupId;
	private long _originalUserGroupId;
	private boolean _setOriginalUserGroupId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _roleId;
	private long _originalRoleId;
	private boolean _setOriginalRoleId;
	private long _companyId;
	private long _columnBitmask;
	private UserGroupGroupRole _escapedModel;
}