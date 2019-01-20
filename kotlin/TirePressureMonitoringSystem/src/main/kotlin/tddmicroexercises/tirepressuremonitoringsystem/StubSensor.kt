package tddmicroexercises.tirepressuremonitoringsystem

import java.util.*


class StubSensor: Sensor {

    private val queue = ArrayDeque<Double>()

    fun setPressureValueToBeChecked(pressureValue: Double) {
        this.queue.offer(pressureValue)
    }

    fun setPressureValuesToBeChecked(pressureValues: DoubleArray) {
        for (pressure in pressureValues) {
            this.queue.offer(pressure)
        }
    }

    override fun popNextPressurePsiValue(): Double {
        return queue.poll()
    }
}
