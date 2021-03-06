/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.sentry.provider.db.generic.service.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-05-05")
public class TListSentryPrivilegesForProviderRequest implements org.apache.thrift.TBase<TListSentryPrivilegesForProviderRequest, TListSentryPrivilegesForProviderRequest._Fields>, java.io.Serializable, Cloneable, Comparable<TListSentryPrivilegesForProviderRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TListSentryPrivilegesForProviderRequest");

  private static final org.apache.thrift.protocol.TField PROTOCOL_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("protocol_version", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField COMPONENT_FIELD_DESC = new org.apache.thrift.protocol.TField("component", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField SERVICE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("serviceName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField GROUPS_FIELD_DESC = new org.apache.thrift.protocol.TField("groups", org.apache.thrift.protocol.TType.SET, (short)4);
  private static final org.apache.thrift.protocol.TField ROLE_SET_FIELD_DESC = new org.apache.thrift.protocol.TField("roleSet", org.apache.thrift.protocol.TType.STRUCT, (short)5);
  private static final org.apache.thrift.protocol.TField AUTHORIZABLES_FIELD_DESC = new org.apache.thrift.protocol.TField("authorizables", org.apache.thrift.protocol.TType.LIST, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TListSentryPrivilegesForProviderRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TListSentryPrivilegesForProviderRequestTupleSchemeFactory());
  }

  private int protocol_version; // required
  private String component; // required
  private String serviceName; // required
  private Set<String> groups; // required
  private TSentryActiveRoleSet roleSet; // required
  private List<TAuthorizable> authorizables; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PROTOCOL_VERSION((short)1, "protocol_version"),
    COMPONENT((short)2, "component"),
    SERVICE_NAME((short)3, "serviceName"),
    GROUPS((short)4, "groups"),
    ROLE_SET((short)5, "roleSet"),
    AUTHORIZABLES((short)6, "authorizables");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PROTOCOL_VERSION
          return PROTOCOL_VERSION;
        case 2: // COMPONENT
          return COMPONENT;
        case 3: // SERVICE_NAME
          return SERVICE_NAME;
        case 4: // GROUPS
          return GROUPS;
        case 5: // ROLE_SET
          return ROLE_SET;
        case 6: // AUTHORIZABLES
          return AUTHORIZABLES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PROTOCOL_VERSION_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.AUTHORIZABLES};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PROTOCOL_VERSION, new org.apache.thrift.meta_data.FieldMetaData("protocol_version", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.COMPONENT, new org.apache.thrift.meta_data.FieldMetaData("component", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SERVICE_NAME, new org.apache.thrift.meta_data.FieldMetaData("serviceName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GROUPS, new org.apache.thrift.meta_data.FieldMetaData("groups", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.ROLE_SET, new org.apache.thrift.meta_data.FieldMetaData("roleSet", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TSentryActiveRoleSet.class)));
    tmpMap.put(_Fields.AUTHORIZABLES, new org.apache.thrift.meta_data.FieldMetaData("authorizables", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TAuthorizable.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TListSentryPrivilegesForProviderRequest.class, metaDataMap);
  }

  public TListSentryPrivilegesForProviderRequest() {
    this.protocol_version = 2;

  }

  public TListSentryPrivilegesForProviderRequest(
    int protocol_version,
    String component,
    String serviceName,
    Set<String> groups,
    TSentryActiveRoleSet roleSet)
  {
    this();
    this.protocol_version = protocol_version;
    setProtocol_versionIsSet(true);
    this.component = component;
    this.serviceName = serviceName;
    this.groups = groups;
    this.roleSet = roleSet;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TListSentryPrivilegesForProviderRequest(TListSentryPrivilegesForProviderRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    this.protocol_version = other.protocol_version;
    if (other.isSetComponent()) {
      this.component = other.component;
    }
    if (other.isSetServiceName()) {
      this.serviceName = other.serviceName;
    }
    if (other.isSetGroups()) {
      Set<String> __this__groups = new HashSet<String>(other.groups);
      this.groups = __this__groups;
    }
    if (other.isSetRoleSet()) {
      this.roleSet = new TSentryActiveRoleSet(other.roleSet);
    }
    if (other.isSetAuthorizables()) {
      List<TAuthorizable> __this__authorizables = new ArrayList<TAuthorizable>(other.authorizables.size());
      for (TAuthorizable other_element : other.authorizables) {
        __this__authorizables.add(new TAuthorizable(other_element));
      }
      this.authorizables = __this__authorizables;
    }
  }

  public TListSentryPrivilegesForProviderRequest deepCopy() {
    return new TListSentryPrivilegesForProviderRequest(this);
  }

  @Override
  public void clear() {
    this.protocol_version = 2;

    this.component = null;
    this.serviceName = null;
    this.groups = null;
    this.roleSet = null;
    this.authorizables = null;
  }

  public int getProtocol_version() {
    return this.protocol_version;
  }

  public void setProtocol_version(int protocol_version) {
    this.protocol_version = protocol_version;
    setProtocol_versionIsSet(true);
  }

  public void unsetProtocol_version() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PROTOCOL_VERSION_ISSET_ID);
  }

  /** Returns true if field protocol_version is set (has been assigned a value) and false otherwise */
  public boolean isSetProtocol_version() {
    return EncodingUtils.testBit(__isset_bitfield, __PROTOCOL_VERSION_ISSET_ID);
  }

  public void setProtocol_versionIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PROTOCOL_VERSION_ISSET_ID, value);
  }

  public String getComponent() {
    return this.component;
  }

  public void setComponent(String component) {
    this.component = component;
  }

  public void unsetComponent() {
    this.component = null;
  }

  /** Returns true if field component is set (has been assigned a value) and false otherwise */
  public boolean isSetComponent() {
    return this.component != null;
  }

  public void setComponentIsSet(boolean value) {
    if (!value) {
      this.component = null;
    }
  }

  public String getServiceName() {
    return this.serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public void unsetServiceName() {
    this.serviceName = null;
  }

  /** Returns true if field serviceName is set (has been assigned a value) and false otherwise */
  public boolean isSetServiceName() {
    return this.serviceName != null;
  }

  public void setServiceNameIsSet(boolean value) {
    if (!value) {
      this.serviceName = null;
    }
  }

  public int getGroupsSize() {
    return (this.groups == null) ? 0 : this.groups.size();
  }

  public java.util.Iterator<String> getGroupsIterator() {
    return (this.groups == null) ? null : this.groups.iterator();
  }

  public void addToGroups(String elem) {
    if (this.groups == null) {
      this.groups = new HashSet<String>();
    }
    this.groups.add(elem);
  }

  public Set<String> getGroups() {
    return this.groups;
  }

  public void setGroups(Set<String> groups) {
    this.groups = groups;
  }

  public void unsetGroups() {
    this.groups = null;
  }

  /** Returns true if field groups is set (has been assigned a value) and false otherwise */
  public boolean isSetGroups() {
    return this.groups != null;
  }

  public void setGroupsIsSet(boolean value) {
    if (!value) {
      this.groups = null;
    }
  }

  public TSentryActiveRoleSet getRoleSet() {
    return this.roleSet;
  }

  public void setRoleSet(TSentryActiveRoleSet roleSet) {
    this.roleSet = roleSet;
  }

  public void unsetRoleSet() {
    this.roleSet = null;
  }

  /** Returns true if field roleSet is set (has been assigned a value) and false otherwise */
  public boolean isSetRoleSet() {
    return this.roleSet != null;
  }

  public void setRoleSetIsSet(boolean value) {
    if (!value) {
      this.roleSet = null;
    }
  }

  public int getAuthorizablesSize() {
    return (this.authorizables == null) ? 0 : this.authorizables.size();
  }

  public java.util.Iterator<TAuthorizable> getAuthorizablesIterator() {
    return (this.authorizables == null) ? null : this.authorizables.iterator();
  }

  public void addToAuthorizables(TAuthorizable elem) {
    if (this.authorizables == null) {
      this.authorizables = new ArrayList<TAuthorizable>();
    }
    this.authorizables.add(elem);
  }

  public List<TAuthorizable> getAuthorizables() {
    return this.authorizables;
  }

  public void setAuthorizables(List<TAuthorizable> authorizables) {
    this.authorizables = authorizables;
  }

  public void unsetAuthorizables() {
    this.authorizables = null;
  }

  /** Returns true if field authorizables is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthorizables() {
    return this.authorizables != null;
  }

  public void setAuthorizablesIsSet(boolean value) {
    if (!value) {
      this.authorizables = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PROTOCOL_VERSION:
      if (value == null) {
        unsetProtocol_version();
      } else {
        setProtocol_version((Integer)value);
      }
      break;

    case COMPONENT:
      if (value == null) {
        unsetComponent();
      } else {
        setComponent((String)value);
      }
      break;

    case SERVICE_NAME:
      if (value == null) {
        unsetServiceName();
      } else {
        setServiceName((String)value);
      }
      break;

    case GROUPS:
      if (value == null) {
        unsetGroups();
      } else {
        setGroups((Set<String>)value);
      }
      break;

    case ROLE_SET:
      if (value == null) {
        unsetRoleSet();
      } else {
        setRoleSet((TSentryActiveRoleSet)value);
      }
      break;

    case AUTHORIZABLES:
      if (value == null) {
        unsetAuthorizables();
      } else {
        setAuthorizables((List<TAuthorizable>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PROTOCOL_VERSION:
      return getProtocol_version();

    case COMPONENT:
      return getComponent();

    case SERVICE_NAME:
      return getServiceName();

    case GROUPS:
      return getGroups();

    case ROLE_SET:
      return getRoleSet();

    case AUTHORIZABLES:
      return getAuthorizables();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PROTOCOL_VERSION:
      return isSetProtocol_version();
    case COMPONENT:
      return isSetComponent();
    case SERVICE_NAME:
      return isSetServiceName();
    case GROUPS:
      return isSetGroups();
    case ROLE_SET:
      return isSetRoleSet();
    case AUTHORIZABLES:
      return isSetAuthorizables();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TListSentryPrivilegesForProviderRequest)
      return this.equals((TListSentryPrivilegesForProviderRequest)that);
    return false;
  }

  public boolean equals(TListSentryPrivilegesForProviderRequest that) {
    if (that == null)
      return false;

    boolean this_present_protocol_version = true;
    boolean that_present_protocol_version = true;
    if (this_present_protocol_version || that_present_protocol_version) {
      if (!(this_present_protocol_version && that_present_protocol_version))
        return false;
      if (this.protocol_version != that.protocol_version)
        return false;
    }

    boolean this_present_component = true && this.isSetComponent();
    boolean that_present_component = true && that.isSetComponent();
    if (this_present_component || that_present_component) {
      if (!(this_present_component && that_present_component))
        return false;
      if (!this.component.equals(that.component))
        return false;
    }

    boolean this_present_serviceName = true && this.isSetServiceName();
    boolean that_present_serviceName = true && that.isSetServiceName();
    if (this_present_serviceName || that_present_serviceName) {
      if (!(this_present_serviceName && that_present_serviceName))
        return false;
      if (!this.serviceName.equals(that.serviceName))
        return false;
    }

    boolean this_present_groups = true && this.isSetGroups();
    boolean that_present_groups = true && that.isSetGroups();
    if (this_present_groups || that_present_groups) {
      if (!(this_present_groups && that_present_groups))
        return false;
      if (!this.groups.equals(that.groups))
        return false;
    }

    boolean this_present_roleSet = true && this.isSetRoleSet();
    boolean that_present_roleSet = true && that.isSetRoleSet();
    if (this_present_roleSet || that_present_roleSet) {
      if (!(this_present_roleSet && that_present_roleSet))
        return false;
      if (!this.roleSet.equals(that.roleSet))
        return false;
    }

    boolean this_present_authorizables = true && this.isSetAuthorizables();
    boolean that_present_authorizables = true && that.isSetAuthorizables();
    if (this_present_authorizables || that_present_authorizables) {
      if (!(this_present_authorizables && that_present_authorizables))
        return false;
      if (!this.authorizables.equals(that.authorizables))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_protocol_version = true;
    list.add(present_protocol_version);
    if (present_protocol_version)
      list.add(protocol_version);

    boolean present_component = true && (isSetComponent());
    list.add(present_component);
    if (present_component)
      list.add(component);

    boolean present_serviceName = true && (isSetServiceName());
    list.add(present_serviceName);
    if (present_serviceName)
      list.add(serviceName);

    boolean present_groups = true && (isSetGroups());
    list.add(present_groups);
    if (present_groups)
      list.add(groups);

    boolean present_roleSet = true && (isSetRoleSet());
    list.add(present_roleSet);
    if (present_roleSet)
      list.add(roleSet);

    boolean present_authorizables = true && (isSetAuthorizables());
    list.add(present_authorizables);
    if (present_authorizables)
      list.add(authorizables);

    return list.hashCode();
  }

  @Override
  public int compareTo(TListSentryPrivilegesForProviderRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetProtocol_version()).compareTo(other.isSetProtocol_version());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProtocol_version()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.protocol_version, other.protocol_version);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetComponent()).compareTo(other.isSetComponent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetComponent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.component, other.component);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetServiceName()).compareTo(other.isSetServiceName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetServiceName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.serviceName, other.serviceName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGroups()).compareTo(other.isSetGroups());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroups()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.groups, other.groups);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRoleSet()).compareTo(other.isSetRoleSet());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRoleSet()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.roleSet, other.roleSet);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAuthorizables()).compareTo(other.isSetAuthorizables());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthorizables()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.authorizables, other.authorizables);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TListSentryPrivilegesForProviderRequest(");
    boolean first = true;

    sb.append("protocol_version:");
    sb.append(this.protocol_version);
    first = false;
    if (!first) sb.append(", ");
    sb.append("component:");
    if (this.component == null) {
      sb.append("null");
    } else {
      sb.append(this.component);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("serviceName:");
    if (this.serviceName == null) {
      sb.append("null");
    } else {
      sb.append(this.serviceName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("groups:");
    if (this.groups == null) {
      sb.append("null");
    } else {
      sb.append(this.groups);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("roleSet:");
    if (this.roleSet == null) {
      sb.append("null");
    } else {
      sb.append(this.roleSet);
    }
    first = false;
    if (isSetAuthorizables()) {
      if (!first) sb.append(", ");
      sb.append("authorizables:");
      if (this.authorizables == null) {
        sb.append("null");
      } else {
        sb.append(this.authorizables);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetProtocol_version()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'protocol_version' is unset! Struct:" + toString());
    }

    if (!isSetComponent()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'component' is unset! Struct:" + toString());
    }

    if (!isSetServiceName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'serviceName' is unset! Struct:" + toString());
    }

    if (!isSetGroups()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'groups' is unset! Struct:" + toString());
    }

    if (!isSetRoleSet()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'roleSet' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
    if (roleSet != null) {
      roleSet.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TListSentryPrivilegesForProviderRequestStandardSchemeFactory implements SchemeFactory {
    public TListSentryPrivilegesForProviderRequestStandardScheme getScheme() {
      return new TListSentryPrivilegesForProviderRequestStandardScheme();
    }
  }

  private static class TListSentryPrivilegesForProviderRequestStandardScheme extends StandardScheme<TListSentryPrivilegesForProviderRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TListSentryPrivilegesForProviderRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PROTOCOL_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.protocol_version = iprot.readI32();
              struct.setProtocol_versionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COMPONENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.component = iprot.readString();
              struct.setComponentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SERVICE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.serviceName = iprot.readString();
              struct.setServiceNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // GROUPS
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set80 = iprot.readSetBegin();
                struct.groups = new HashSet<String>(2*_set80.size);
                String _elem81;
                for (int _i82 = 0; _i82 < _set80.size; ++_i82)
                {
                  _elem81 = iprot.readString();
                  struct.groups.add(_elem81);
                }
                iprot.readSetEnd();
              }
              struct.setGroupsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ROLE_SET
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.roleSet = new TSentryActiveRoleSet();
              struct.roleSet.read(iprot);
              struct.setRoleSetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // AUTHORIZABLES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list83 = iprot.readListBegin();
                struct.authorizables = new ArrayList<TAuthorizable>(_list83.size);
                TAuthorizable _elem84;
                for (int _i85 = 0; _i85 < _list83.size; ++_i85)
                {
                  _elem84 = new TAuthorizable();
                  _elem84.read(iprot);
                  struct.authorizables.add(_elem84);
                }
                iprot.readListEnd();
              }
              struct.setAuthorizablesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TListSentryPrivilegesForProviderRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(PROTOCOL_VERSION_FIELD_DESC);
      oprot.writeI32(struct.protocol_version);
      oprot.writeFieldEnd();
      if (struct.component != null) {
        oprot.writeFieldBegin(COMPONENT_FIELD_DESC);
        oprot.writeString(struct.component);
        oprot.writeFieldEnd();
      }
      if (struct.serviceName != null) {
        oprot.writeFieldBegin(SERVICE_NAME_FIELD_DESC);
        oprot.writeString(struct.serviceName);
        oprot.writeFieldEnd();
      }
      if (struct.groups != null) {
        oprot.writeFieldBegin(GROUPS_FIELD_DESC);
        {
          oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, struct.groups.size()));
          for (String _iter86 : struct.groups)
          {
            oprot.writeString(_iter86);
          }
          oprot.writeSetEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.roleSet != null) {
        oprot.writeFieldBegin(ROLE_SET_FIELD_DESC);
        struct.roleSet.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.authorizables != null) {
        if (struct.isSetAuthorizables()) {
          oprot.writeFieldBegin(AUTHORIZABLES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.authorizables.size()));
            for (TAuthorizable _iter87 : struct.authorizables)
            {
              _iter87.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TListSentryPrivilegesForProviderRequestTupleSchemeFactory implements SchemeFactory {
    public TListSentryPrivilegesForProviderRequestTupleScheme getScheme() {
      return new TListSentryPrivilegesForProviderRequestTupleScheme();
    }
  }

  private static class TListSentryPrivilegesForProviderRequestTupleScheme extends TupleScheme<TListSentryPrivilegesForProviderRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TListSentryPrivilegesForProviderRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.protocol_version);
      oprot.writeString(struct.component);
      oprot.writeString(struct.serviceName);
      {
        oprot.writeI32(struct.groups.size());
        for (String _iter88 : struct.groups)
        {
          oprot.writeString(_iter88);
        }
      }
      struct.roleSet.write(oprot);
      BitSet optionals = new BitSet();
      if (struct.isSetAuthorizables()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetAuthorizables()) {
        {
          oprot.writeI32(struct.authorizables.size());
          for (TAuthorizable _iter89 : struct.authorizables)
          {
            _iter89.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TListSentryPrivilegesForProviderRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.protocol_version = iprot.readI32();
      struct.setProtocol_versionIsSet(true);
      struct.component = iprot.readString();
      struct.setComponentIsSet(true);
      struct.serviceName = iprot.readString();
      struct.setServiceNameIsSet(true);
      {
        org.apache.thrift.protocol.TSet _set90 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
        struct.groups = new HashSet<String>(2*_set90.size);
        String _elem91;
        for (int _i92 = 0; _i92 < _set90.size; ++_i92)
        {
          _elem91 = iprot.readString();
          struct.groups.add(_elem91);
        }
      }
      struct.setGroupsIsSet(true);
      struct.roleSet = new TSentryActiveRoleSet();
      struct.roleSet.read(iprot);
      struct.setRoleSetIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list93 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.authorizables = new ArrayList<TAuthorizable>(_list93.size);
          TAuthorizable _elem94;
          for (int _i95 = 0; _i95 < _list93.size; ++_i95)
          {
            _elem94 = new TAuthorizable();
            _elem94.read(iprot);
            struct.authorizables.add(_elem94);
          }
        }
        struct.setAuthorizablesIsSet(true);
      }
    }
  }

}

