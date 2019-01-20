package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Assert.assertEquals
import org.junit.Test

class TestAlarm {

    @Test
    fun the_alarm_will_be_off_if_the_pressure_value_is_ok() {
        //Given
        val sensor = StubSensor()
        sensor.setPressureValueToBeChecked(Alarm.LowPressureThreshold)
        val alarm = Alarm(sensor)

        //When
        alarm.check()

        //Then
        assertEquals(false, alarm.isAlarmOn)
    }

    @Test
    fun the_alarm_will_be_on_if_the_pressure_value_is_lower(){
        //Given
        val sensor = StubSensor()
        sensor.setPressureValueToBeChecked(Alarm.LowPressureThreshold - 1)
        val alarm = Alarm(sensor)

        //When
        alarm.check()

        //Then
        assertEquals(true, alarm.isAlarmOn)
    }

    @Test
    fun the_alarm_will_be_on_if_the_pressure_value_is_higher(){
        //Given
        val sensor = StubSensor()
        sensor.setPressureValueToBeChecked(Alarm.HighPressureThreshold + 1)
        val alarm = Alarm(sensor)

        //When
        alarm.check()

        //Then
        assertEquals(true, alarm.isAlarmOn)
    }

    @Test
    fun the_alarm_will_still_one_if_an_intermediate_valid_pressure_is_set(){
        //Given
        val sensor = StubSensor()
        sensor.setPressureValuesToBeChecked(
            doubleArrayOf(
                Alarm.LowPressureThreshold,
                Alarm.LowPressureThreshold - 1,
                Alarm.LowPressureThreshold
            ))
        val alarm = Alarm(sensor)

        //When
        alarm.check()
        alarm.check()
        alarm.check()

        //Then
        assertEquals(true, alarm.isAlarmOn)
    }
}
