/**
 * Created by tobias.hehrlein on 2019-08-07.
 */

expect fun getCurrentDate() : String

fun getDate() : String {
    return "Today's date is ${getCurrentDate()}"
}