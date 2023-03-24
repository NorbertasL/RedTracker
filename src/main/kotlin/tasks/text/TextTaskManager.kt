package tasks.text

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class TextTaskManager: ListenerAdapter() {
    //stores all text tasks
    private val tasks: MutableList<AbstractTextCommand> = ArrayList()

    /**
     * All text task need to be initialised in this constructor
     */
    init {
        tasks.add(PingTask())
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if(event.message == null
            || event.message.contentRaw.length < 2
            || event.message.contentRaw[0] != '!'){
            return
        }

        //removing 1st char from command since it's the command indicator char.
        val callerCmd: String = event.message.contentRaw.split(" ")[0].substring(1)

        //Looping tough all text tasks and executed the ones that are called
        for (task in tasks){
            task.runCommandIfApplicable(event, callerCmd)
        }
    }
}