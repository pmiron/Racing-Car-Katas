package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Assert.assertEquals
import org.junit.Test

class TestAlarm {

    @Test
    fun foo() {
        val sensor = RandomSensor()
        val alarm = Alarm(sensor)
        assertEquals(false, alarm.isAlarmOn)
    }
}
