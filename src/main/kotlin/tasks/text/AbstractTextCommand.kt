package tasks.text

import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.unions.GuildMessageChannelUnion
import net.dv8tion.jda.api.events.message.MessageReceivedEvent

/**
 * All Text Tasks need to inherit this abstract class AND add the subclass to TextTaskManager constructor.
 * Keywords(commands) are entered as a string separated by a space(if more than 1 commands exist for the same task,
 * like a shot hand)
 */
abstract class AbstractTextCommand(commands: String) {
    private val commandsList: List<String> = commands.split(" ")

    /**
     * Validates the task and runs it if everything is valid.
     */
    fun runCommandIfApplicable(event: MessageReceivedEvent, command: String) {
        if(validCommand(command)
            && validPermissions(event.author)
            && validChannel(event.guildChannel)){

            execute(event)
        }
    }

    private fun validChannel(guildChannel: GuildMessageChannelUnion): Boolean {
        //TODO Implement validChannel check
        return true
    }
    private fun validPermissions(author: User): Boolean {
        //TODO //TODO Implement validPermissions check
        return true
    }

    private fun validCommand(command: String): Boolean {
        return commandsList.any{it.equals(command, ignoreCase = true)}
    }

    /**
     * Your command execution code
     */
    abstract fun execute(event: MessageReceivedEvent)
}