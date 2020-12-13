// Code generated by moshi-kotlin-codegen. Do not edit.
package son.ysy.useful.dependencies.model.single

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.internal.Util
import java.lang.NullPointerException
import kotlin.String
import kotlin.Suppress
import kotlin.collections.emptySet
import kotlin.text.buildString

@Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION", "RedundantExplicitType",
    "LocalVariableName")
class SingleDependencyJsonAdapter(
  moshi: Moshi
) : JsonAdapter<SingleDependency>() {
  private val options: JsonReader.Options = JsonReader.Options.of("name", "version", "link",
      "group", "module", "remark")

  private val stringAdapter: JsonAdapter<String> = moshi.adapter(String::class.java, emptySet(),
      "name")

  private val nullableStringAdapter: JsonAdapter<String?> = moshi.adapter(String::class.java,
      emptySet(), "link")

  override fun toString(): String = buildString(38) {
      append("GeneratedJsonAdapter(").append("SingleDependency").append(')') }

  override fun fromJson(reader: JsonReader): SingleDependency {
    var name: String? = null
    var version: String? = null
    var link: String? = null
    var group: String? = null
    var module: String? = null
    var remark: String? = null
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> name = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("name", "name",
            reader)
        1 -> version = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("version",
            "version", reader)
        2 -> link = nullableStringAdapter.fromJson(reader)
        3 -> group = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("group", "group",
            reader)
        4 -> module = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("module",
            "module", reader)
        5 -> remark = nullableStringAdapter.fromJson(reader)
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    return SingleDependency(
        name = name ?: throw Util.missingProperty("name", "name", reader),
        version = version ?: throw Util.missingProperty("version", "version", reader),
        link = link,
        group = group ?: throw Util.missingProperty("group", "group", reader),
        module = module ?: throw Util.missingProperty("module", "module", reader),
        remark = remark
    )
  }

  override fun toJson(writer: JsonWriter, value: SingleDependency?) {
    if (value == null) {
      throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("name")
    stringAdapter.toJson(writer, value.name)
    writer.name("version")
    stringAdapter.toJson(writer, value.version)
    writer.name("link")
    nullableStringAdapter.toJson(writer, value.link)
    writer.name("group")
    stringAdapter.toJson(writer, value.group)
    writer.name("module")
    stringAdapter.toJson(writer, value.module)
    writer.name("remark")
    nullableStringAdapter.toJson(writer, value.remark)
    writer.endObject()
  }
}
