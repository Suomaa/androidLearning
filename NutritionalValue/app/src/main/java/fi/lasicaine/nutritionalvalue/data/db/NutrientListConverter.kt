package fi.lasicaine.nutritionalvalue.data.db

import androidx.room.TypeConverter
import com.squareup.moshi.*
import fi.lasicaine.nutritionalvalue.model.*

class NutrientListConverter {
    private val moshi = Moshi.Builder().build()
    private val nutrientList = Types.newParameterizedType(
        List::class.java, Nutrient::class.java
    )
    private val adapter = moshi.adapter<List<Nutrient>>(nutrientList)

    @TypeConverter
    fun toString(nutrient: List<Nutrient>): String = adapter.toJson(nutrient)

    @TypeConverter
    fun toListOfNutrient(json: String): List<Nutrient> = adapter.fromJson(json) ?: emptyList()
}

class NutrientTypeConverter {

    @TypeConverter
    fun toString(nutrientType: NutrientType) = nutrientType.name

    @TypeConverter
    fun toNutrientType(name: String) = NutrientType.valueOf(name)
}