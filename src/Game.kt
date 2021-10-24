

class Game {
    private lateinit var player1: Player
    private lateinit var player2: Player
    private lateinit var board: Board

    fun startGame(){
        printHeaderText()
        getPlayersName()
        getBoardSize()
        printStartGameInfo()
    }

    private fun printHeaderText() {
        println("Connect Four")
    }

    private fun getPlayersName() {
        println("First player's name:")
        player1 = Player(inputDataFromUser())
        println("Second player's name:")
        player2 = Player(inputDataFromUser())
    }

    private fun getBoardSize() {
        println("Set the board dimensions (Rows x Columns)")
        println("Press Enter for default (6 x 7)")


        while (true) {
            val str = inputDataFromUser()
            if (str == "\n"){
                board = Board(6, 7)
                break
            }
            try {
                val list = str.lowercase().split("x")
                if (list.size != 2)
                    throw Exception()
                val row = list[0].trim().toInt()
                val columns = list[1].trim().toInt()

                if (row !in 5..9){
                    println("Board rows should be from 5 to 9")
                    continue
                }
                if (columns !in 5..9){
                    println("Board columns should be from 5 to 9")
                    continue
                }
                board = Board(row, columns)
                break
            } catch (e: Exception){
                println("Invalid input")
            }
        }
    }

    private fun printStartGameInfo() {
        println("${player1.name} VS ${player2.name}")
        println("${board.rows} X ${board.columns} board")
    }
}