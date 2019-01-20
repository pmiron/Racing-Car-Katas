package tddmicroexercises.tirepressuremonitoringsystem

class Alarm(var sensor: Sensor) {

    var isAlarmOn = false
        internal set

    fun check() {
        val psiPressureValue = sensor.popNextPressurePsiValue()

        if (psiPressureOutOfRange(psiPressureValue)) {
            isAlarmOn = true
        }
    }

    fun psiPressureOutOfRange(psiPressureValue: Double): Boolean {
        return psiPressureValue < LowPressureThreshold || psiPressureValue > HighPressureThreshold
    }

    companion object {
        val LowPressureThreshold = 17.0
        val HighPressureThreshold = 21.0
    }
}
