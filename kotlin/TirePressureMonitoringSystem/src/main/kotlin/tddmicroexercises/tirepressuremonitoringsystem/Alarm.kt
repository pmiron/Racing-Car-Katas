package tddmicroexercises.tirepressuremonitoringsystem

class Alarm(var sensor: Sensor) {

    var isAlarmOn = false
        internal set

    fun check() {
        val psiPressureValue = sensor.popNextPressurePsiValue()

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
            isAlarmOn = true
        }
    }

    companion object {
        val LowPressureThreshold = 17.0
        val HighPressureThreshold = 21.0
    }
}
