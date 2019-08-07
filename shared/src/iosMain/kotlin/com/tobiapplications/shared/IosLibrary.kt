import platform.Foundation.NSDate

/**
 * Created by tobias.hehrlein on 2019-08-07.
 */

actual fun getCurrentDate() : String {
    return NSDate().toString()
}