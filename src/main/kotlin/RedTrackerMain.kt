import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent
import tasks.text.TextTaskManager

//TODO Add logger
/**
 * @args[0] is the discord API TOKEN.
 * @args[1] is the Database link.
 * @args[2] is the Database Username and Password separated by a space.
 * @args[3] OPTIONAL(Default = 0) logging level
 *  0 - Only Errors
 */
fun main(args: Array<String>){
    if(args.size >= 4){
        //TODO set logging level
    }else if(args.size < 3){
        //TODO Error Msg
        //return
    }
    //TODO Set Database
    //TODO Set Database Credentials

    val jda: JDA = JDABuilder.createLight(args[0],
        GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
        .addEventListeners(TextTaskManager())
        .build().awaitReady()

    println("\u001B[32mRed Tracker is ready to go!")
}
