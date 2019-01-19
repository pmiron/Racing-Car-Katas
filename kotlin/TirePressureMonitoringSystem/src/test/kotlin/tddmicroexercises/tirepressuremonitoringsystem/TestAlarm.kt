package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Test
import org.junit.Assert.*

class TestAlarm {

    @Test
    fun foo() {
        val sensor = Sensor()
        val alarm = Alarm(sensor)
        assertEquals(false, alarm.isAlarmOn)
    }
}
