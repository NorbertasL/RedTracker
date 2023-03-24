package tasks.text

import net.dv8tion.jda.api.events.message.MessageReceivedEvent

class PingTask: AbstractTextCommand("ping pingtest, pt") {
    override fun execute(event: MessageReceivedEvent) {
        print("Pong")
    }
}