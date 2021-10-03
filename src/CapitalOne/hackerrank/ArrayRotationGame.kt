package CapitalOne.hackerrank

class ArrayRotationGame {}

fun main(args: Array<String>) {

//    getMaxElementIndexesQuicker(arrayOf(1, 2, 3, 4), arrayOf(1, 2, 3, 4)) contentEquals  arrayOf( 2, 1, 0, 3)


    val result = getMaxElementIndexesQuicker(arrayOf(1, 4, 2, 3), arrayOf(1, 2, 3, 4))
    val result2 = getMaxElementIndexes(arrayOf(1, 4, 2, 3), arrayOf(1, 2, 3, 4))

    println(result.joinToString(" , "))
    println()
    println(result2.joinToString(" , "))
}

fun getMaxElementIndexesQuicker(a: Array<Int>, rotate: Array<Int>): Array<Int> {
    val maxIndex = a.indexOf(a.max())
    return rotate.map {
        val actualRotation = it.rem(a.size)
        if (actualRotation > maxIndex)
            a.size - actualRotation + maxIndex
        else
            maxIndex - actualRotation
    }.toTypedArray()
}


fun getMaxElementIndexes(a: Array<Int>, rotate: Array<Int>): Array<Int> {
    return rotate.map {
        val o = leftRotation(a, it)
        o.indexOf(o.max())
    }.toTypedArray()
}

fun leftRotation(a: Array<Int>, rotateBy: Int): Array<Int> {
    val elementsToTake = a.size - rotateBy.rem(a.size)
    val stay = a.takeLast(elementsToTake)
    val toRotate = a.take(rotateBy)
    return stay.plus(toRotate).toTypedArray()
}