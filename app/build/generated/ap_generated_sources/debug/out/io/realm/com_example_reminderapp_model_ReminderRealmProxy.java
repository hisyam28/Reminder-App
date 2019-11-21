package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_reminderapp_model_ReminderRealmProxy extends com.example.reminderapp.model.Reminder
    implements RealmObjectProxy, com_example_reminderapp_model_ReminderRealmProxyInterface {

    static final class ReminderColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long namaReminderIndex;
        long tanggalIndex;
        long waktuIndex;
        long catatanIndex;
        long frekuensiDataIndex;
        long prioritasIndex;
        long tagIndex;
        long reminderActiveIndex;

        ReminderColumnInfo(OsSchemaInfo schemaInfo) {
            super(9);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Reminder");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.namaReminderIndex = addColumnDetails("namaReminder", "namaReminder", objectSchemaInfo);
            this.tanggalIndex = addColumnDetails("tanggal", "tanggal", objectSchemaInfo);
            this.waktuIndex = addColumnDetails("waktu", "waktu", objectSchemaInfo);
            this.catatanIndex = addColumnDetails("catatan", "catatan", objectSchemaInfo);
            this.frekuensiDataIndex = addColumnDetails("frekuensiData", "frekuensiData", objectSchemaInfo);
            this.prioritasIndex = addColumnDetails("prioritas", "prioritas", objectSchemaInfo);
            this.tagIndex = addColumnDetails("tag", "tag", objectSchemaInfo);
            this.reminderActiveIndex = addColumnDetails("reminderActive", "reminderActive", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ReminderColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ReminderColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ReminderColumnInfo src = (ReminderColumnInfo) rawSrc;
            final ReminderColumnInfo dst = (ReminderColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.namaReminderIndex = src.namaReminderIndex;
            dst.tanggalIndex = src.tanggalIndex;
            dst.waktuIndex = src.waktuIndex;
            dst.catatanIndex = src.catatanIndex;
            dst.frekuensiDataIndex = src.frekuensiDataIndex;
            dst.prioritasIndex = src.prioritasIndex;
            dst.tagIndex = src.tagIndex;
            dst.reminderActiveIndex = src.reminderActiveIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ReminderColumnInfo columnInfo;
    private ProxyState<com.example.reminderapp.model.Reminder> proxyState;

    com_example_reminderapp_model_ReminderRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ReminderColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.reminderapp.model.Reminder>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$namaReminder() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.namaReminderIndex);
    }

    @Override
    public void realmSet$namaReminder(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.namaReminderIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.namaReminderIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.namaReminderIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.namaReminderIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$tanggal() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tanggalIndex);
    }

    @Override
    public void realmSet$tanggal(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tanggalIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tanggalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tanggalIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tanggalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$waktu() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.waktuIndex);
    }

    @Override
    public void realmSet$waktu(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.waktuIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.waktuIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.waktuIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.waktuIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$catatan() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.catatanIndex);
    }

    @Override
    public void realmSet$catatan(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.catatanIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.catatanIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.catatanIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.catatanIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$frekuensiData() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.frekuensiDataIndex);
    }

    @Override
    public void realmSet$frekuensiData(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.frekuensiDataIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.frekuensiDataIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.frekuensiDataIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.frekuensiDataIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$prioritas() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.prioritasIndex);
    }

    @Override
    public void realmSet$prioritas(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.prioritasIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.prioritasIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.prioritasIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.prioritasIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$tag() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tagIndex);
    }

    @Override
    public void realmSet$tag(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tagIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tagIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tagIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tagIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$reminderActive() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.reminderActiveIndex);
    }

    @Override
    public void realmSet$reminderActive(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.reminderActiveIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.reminderActiveIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Reminder", 9, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("namaReminder", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("tanggal", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("waktu", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("catatan", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("frekuensiData", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("prioritas", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("tag", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("reminderActive", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ReminderColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ReminderColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Reminder";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Reminder";
    }

    @SuppressWarnings("cast")
    public static com.example.reminderapp.model.Reminder createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.reminderapp.model.Reminder obj = null;
        if (update) {
            Table table = realm.getTable(com.example.reminderapp.model.Reminder.class);
            ReminderColumnInfo columnInfo = (ReminderColumnInfo) realm.getSchema().getColumnInfo(com.example.reminderapp.model.Reminder.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.reminderapp.model.Reminder.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_reminderapp_model_ReminderRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_example_reminderapp_model_ReminderRealmProxy) realm.createObjectInternal(com.example.reminderapp.model.Reminder.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_reminderapp_model_ReminderRealmProxy) realm.createObjectInternal(com.example.reminderapp.model.Reminder.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_example_reminderapp_model_ReminderRealmProxyInterface objProxy = (com_example_reminderapp_model_ReminderRealmProxyInterface) obj;
        if (json.has("namaReminder")) {
            if (json.isNull("namaReminder")) {
                objProxy.realmSet$namaReminder(null);
            } else {
                objProxy.realmSet$namaReminder((String) json.getString("namaReminder"));
            }
        }
        if (json.has("tanggal")) {
            if (json.isNull("tanggal")) {
                objProxy.realmSet$tanggal(null);
            } else {
                objProxy.realmSet$tanggal((String) json.getString("tanggal"));
            }
        }
        if (json.has("waktu")) {
            if (json.isNull("waktu")) {
                objProxy.realmSet$waktu(null);
            } else {
                objProxy.realmSet$waktu((String) json.getString("waktu"));
            }
        }
        if (json.has("catatan")) {
            if (json.isNull("catatan")) {
                objProxy.realmSet$catatan(null);
            } else {
                objProxy.realmSet$catatan((String) json.getString("catatan"));
            }
        }
        if (json.has("frekuensiData")) {
            if (json.isNull("frekuensiData")) {
                objProxy.realmSet$frekuensiData(null);
            } else {
                objProxy.realmSet$frekuensiData((String) json.getString("frekuensiData"));
            }
        }
        if (json.has("prioritas")) {
            if (json.isNull("prioritas")) {
                objProxy.realmSet$prioritas(null);
            } else {
                objProxy.realmSet$prioritas((String) json.getString("prioritas"));
            }
        }
        if (json.has("tag")) {
            if (json.isNull("tag")) {
                objProxy.realmSet$tag(null);
            } else {
                objProxy.realmSet$tag((String) json.getString("tag"));
            }
        }
        if (json.has("reminderActive")) {
            if (json.isNull("reminderActive")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'reminderActive' to null.");
            } else {
                objProxy.realmSet$reminderActive((boolean) json.getBoolean("reminderActive"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.reminderapp.model.Reminder createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.reminderapp.model.Reminder obj = new com.example.reminderapp.model.Reminder();
        final com_example_reminderapp_model_ReminderRealmProxyInterface objProxy = (com_example_reminderapp_model_ReminderRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("namaReminder")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$namaReminder((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$namaReminder(null);
                }
            } else if (name.equals("tanggal")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tanggal((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$tanggal(null);
                }
            } else if (name.equals("waktu")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$waktu((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$waktu(null);
                }
            } else if (name.equals("catatan")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$catatan((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$catatan(null);
                }
            } else if (name.equals("frekuensiData")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$frekuensiData((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$frekuensiData(null);
                }
            } else if (name.equals("prioritas")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$prioritas((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$prioritas(null);
                }
            } else if (name.equals("tag")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tag((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$tag(null);
                }
            } else if (name.equals("reminderActive")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$reminderActive((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'reminderActive' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    private static com_example_reminderapp_model_ReminderRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.reminderapp.model.Reminder.class), false, Collections.<String>emptyList());
        io.realm.com_example_reminderapp_model_ReminderRealmProxy obj = new io.realm.com_example_reminderapp_model_ReminderRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.reminderapp.model.Reminder copyOrUpdate(Realm realm, ReminderColumnInfo columnInfo, com.example.reminderapp.model.Reminder object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.reminderapp.model.Reminder) cachedRealmObject;
        }

        com.example.reminderapp.model.Reminder realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.reminderapp.model.Reminder.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_reminderapp_model_ReminderRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.reminderapp.model.Reminder copy(Realm realm, ReminderColumnInfo columnInfo, com.example.reminderapp.model.Reminder newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.reminderapp.model.Reminder) cachedRealmObject;
        }

        com_example_reminderapp_model_ReminderRealmProxyInterface realmObjectSource = (com_example_reminderapp_model_ReminderRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.reminderapp.model.Reminder.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.namaReminderIndex, realmObjectSource.realmGet$namaReminder());
        builder.addString(columnInfo.tanggalIndex, realmObjectSource.realmGet$tanggal());
        builder.addString(columnInfo.waktuIndex, realmObjectSource.realmGet$waktu());
        builder.addString(columnInfo.catatanIndex, realmObjectSource.realmGet$catatan());
        builder.addString(columnInfo.frekuensiDataIndex, realmObjectSource.realmGet$frekuensiData());
        builder.addString(columnInfo.prioritasIndex, realmObjectSource.realmGet$prioritas());
        builder.addString(columnInfo.tagIndex, realmObjectSource.realmGet$tag());
        builder.addBoolean(columnInfo.reminderActiveIndex, realmObjectSource.realmGet$reminderActive());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_reminderapp_model_ReminderRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.example.reminderapp.model.Reminder object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.reminderapp.model.Reminder.class);
        long tableNativePtr = table.getNativePtr();
        ReminderColumnInfo columnInfo = (ReminderColumnInfo) realm.getSchema().getColumnInfo(com.example.reminderapp.model.Reminder.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$namaReminder = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$namaReminder();
        if (realmGet$namaReminder != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.namaReminderIndex, rowIndex, realmGet$namaReminder, false);
        }
        String realmGet$tanggal = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$tanggal();
        if (realmGet$tanggal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tanggalIndex, rowIndex, realmGet$tanggal, false);
        }
        String realmGet$waktu = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$waktu();
        if (realmGet$waktu != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.waktuIndex, rowIndex, realmGet$waktu, false);
        }
        String realmGet$catatan = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$catatan();
        if (realmGet$catatan != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.catatanIndex, rowIndex, realmGet$catatan, false);
        }
        String realmGet$frekuensiData = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$frekuensiData();
        if (realmGet$frekuensiData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.frekuensiDataIndex, rowIndex, realmGet$frekuensiData, false);
        }
        String realmGet$prioritas = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$prioritas();
        if (realmGet$prioritas != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.prioritasIndex, rowIndex, realmGet$prioritas, false);
        }
        String realmGet$tag = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$tag();
        if (realmGet$tag != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.reminderActiveIndex, rowIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$reminderActive(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.reminderapp.model.Reminder.class);
        long tableNativePtr = table.getNativePtr();
        ReminderColumnInfo columnInfo = (ReminderColumnInfo) realm.getSchema().getColumnInfo(com.example.reminderapp.model.Reminder.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.reminderapp.model.Reminder object = null;
        while (objects.hasNext()) {
            object = (com.example.reminderapp.model.Reminder) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$namaReminder = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$namaReminder();
            if (realmGet$namaReminder != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.namaReminderIndex, rowIndex, realmGet$namaReminder, false);
            }
            String realmGet$tanggal = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$tanggal();
            if (realmGet$tanggal != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tanggalIndex, rowIndex, realmGet$tanggal, false);
            }
            String realmGet$waktu = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$waktu();
            if (realmGet$waktu != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.waktuIndex, rowIndex, realmGet$waktu, false);
            }
            String realmGet$catatan = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$catatan();
            if (realmGet$catatan != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.catatanIndex, rowIndex, realmGet$catatan, false);
            }
            String realmGet$frekuensiData = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$frekuensiData();
            if (realmGet$frekuensiData != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.frekuensiDataIndex, rowIndex, realmGet$frekuensiData, false);
            }
            String realmGet$prioritas = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$prioritas();
            if (realmGet$prioritas != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.prioritasIndex, rowIndex, realmGet$prioritas, false);
            }
            String realmGet$tag = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$tag();
            if (realmGet$tag != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.reminderActiveIndex, rowIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$reminderActive(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.reminderapp.model.Reminder object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.reminderapp.model.Reminder.class);
        long tableNativePtr = table.getNativePtr();
        ReminderColumnInfo columnInfo = (ReminderColumnInfo) realm.getSchema().getColumnInfo(com.example.reminderapp.model.Reminder.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$namaReminder = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$namaReminder();
        if (realmGet$namaReminder != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.namaReminderIndex, rowIndex, realmGet$namaReminder, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.namaReminderIndex, rowIndex, false);
        }
        String realmGet$tanggal = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$tanggal();
        if (realmGet$tanggal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tanggalIndex, rowIndex, realmGet$tanggal, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tanggalIndex, rowIndex, false);
        }
        String realmGet$waktu = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$waktu();
        if (realmGet$waktu != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.waktuIndex, rowIndex, realmGet$waktu, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.waktuIndex, rowIndex, false);
        }
        String realmGet$catatan = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$catatan();
        if (realmGet$catatan != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.catatanIndex, rowIndex, realmGet$catatan, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.catatanIndex, rowIndex, false);
        }
        String realmGet$frekuensiData = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$frekuensiData();
        if (realmGet$frekuensiData != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.frekuensiDataIndex, rowIndex, realmGet$frekuensiData, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.frekuensiDataIndex, rowIndex, false);
        }
        String realmGet$prioritas = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$prioritas();
        if (realmGet$prioritas != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.prioritasIndex, rowIndex, realmGet$prioritas, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.prioritasIndex, rowIndex, false);
        }
        String realmGet$tag = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$tag();
        if (realmGet$tag != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tagIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.reminderActiveIndex, rowIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$reminderActive(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.reminderapp.model.Reminder.class);
        long tableNativePtr = table.getNativePtr();
        ReminderColumnInfo columnInfo = (ReminderColumnInfo) realm.getSchema().getColumnInfo(com.example.reminderapp.model.Reminder.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.example.reminderapp.model.Reminder object = null;
        while (objects.hasNext()) {
            object = (com.example.reminderapp.model.Reminder) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$namaReminder = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$namaReminder();
            if (realmGet$namaReminder != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.namaReminderIndex, rowIndex, realmGet$namaReminder, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.namaReminderIndex, rowIndex, false);
            }
            String realmGet$tanggal = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$tanggal();
            if (realmGet$tanggal != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tanggalIndex, rowIndex, realmGet$tanggal, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tanggalIndex, rowIndex, false);
            }
            String realmGet$waktu = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$waktu();
            if (realmGet$waktu != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.waktuIndex, rowIndex, realmGet$waktu, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.waktuIndex, rowIndex, false);
            }
            String realmGet$catatan = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$catatan();
            if (realmGet$catatan != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.catatanIndex, rowIndex, realmGet$catatan, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.catatanIndex, rowIndex, false);
            }
            String realmGet$frekuensiData = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$frekuensiData();
            if (realmGet$frekuensiData != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.frekuensiDataIndex, rowIndex, realmGet$frekuensiData, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.frekuensiDataIndex, rowIndex, false);
            }
            String realmGet$prioritas = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$prioritas();
            if (realmGet$prioritas != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.prioritasIndex, rowIndex, realmGet$prioritas, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.prioritasIndex, rowIndex, false);
            }
            String realmGet$tag = ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$tag();
            if (realmGet$tag != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tagIndex, rowIndex, realmGet$tag, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tagIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.reminderActiveIndex, rowIndex, ((com_example_reminderapp_model_ReminderRealmProxyInterface) object).realmGet$reminderActive(), false);
        }
    }

    public static com.example.reminderapp.model.Reminder createDetachedCopy(com.example.reminderapp.model.Reminder realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.reminderapp.model.Reminder unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.reminderapp.model.Reminder();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.reminderapp.model.Reminder) cachedObject.object;
            }
            unmanagedObject = (com.example.reminderapp.model.Reminder) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_reminderapp_model_ReminderRealmProxyInterface unmanagedCopy = (com_example_reminderapp_model_ReminderRealmProxyInterface) unmanagedObject;
        com_example_reminderapp_model_ReminderRealmProxyInterface realmSource = (com_example_reminderapp_model_ReminderRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$namaReminder(realmSource.realmGet$namaReminder());
        unmanagedCopy.realmSet$tanggal(realmSource.realmGet$tanggal());
        unmanagedCopy.realmSet$waktu(realmSource.realmGet$waktu());
        unmanagedCopy.realmSet$catatan(realmSource.realmGet$catatan());
        unmanagedCopy.realmSet$frekuensiData(realmSource.realmGet$frekuensiData());
        unmanagedCopy.realmSet$prioritas(realmSource.realmGet$prioritas());
        unmanagedCopy.realmSet$tag(realmSource.realmGet$tag());
        unmanagedCopy.realmSet$reminderActive(realmSource.realmGet$reminderActive());

        return unmanagedObject;
    }

    static com.example.reminderapp.model.Reminder update(Realm realm, ReminderColumnInfo columnInfo, com.example.reminderapp.model.Reminder realmObject, com.example.reminderapp.model.Reminder newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_example_reminderapp_model_ReminderRealmProxyInterface realmObjectTarget = (com_example_reminderapp_model_ReminderRealmProxyInterface) realmObject;
        com_example_reminderapp_model_ReminderRealmProxyInterface realmObjectSource = (com_example_reminderapp_model_ReminderRealmProxyInterface) newObject;
        Table table = realm.getTable(com.example.reminderapp.model.Reminder.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.namaReminderIndex, realmObjectSource.realmGet$namaReminder());
        builder.addString(columnInfo.tanggalIndex, realmObjectSource.realmGet$tanggal());
        builder.addString(columnInfo.waktuIndex, realmObjectSource.realmGet$waktu());
        builder.addString(columnInfo.catatanIndex, realmObjectSource.realmGet$catatan());
        builder.addString(columnInfo.frekuensiDataIndex, realmObjectSource.realmGet$frekuensiData());
        builder.addString(columnInfo.prioritasIndex, realmObjectSource.realmGet$prioritas());
        builder.addString(columnInfo.tagIndex, realmObjectSource.realmGet$tag());
        builder.addBoolean(columnInfo.reminderActiveIndex, realmObjectSource.realmGet$reminderActive());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Reminder = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{namaReminder:");
        stringBuilder.append(realmGet$namaReminder() != null ? realmGet$namaReminder() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tanggal:");
        stringBuilder.append(realmGet$tanggal() != null ? realmGet$tanggal() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{waktu:");
        stringBuilder.append(realmGet$waktu() != null ? realmGet$waktu() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{catatan:");
        stringBuilder.append(realmGet$catatan() != null ? realmGet$catatan() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{frekuensiData:");
        stringBuilder.append(realmGet$frekuensiData() != null ? realmGet$frekuensiData() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{prioritas:");
        stringBuilder.append(realmGet$prioritas() != null ? realmGet$prioritas() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tag:");
        stringBuilder.append(realmGet$tag() != null ? realmGet$tag() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reminderActive:");
        stringBuilder.append(realmGet$reminderActive());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_reminderapp_model_ReminderRealmProxy aReminder = (com_example_reminderapp_model_ReminderRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aReminder.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aReminder.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aReminder.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
