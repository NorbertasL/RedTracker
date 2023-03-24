import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.core.config.Configurator
import tasks.text.TextTaskManager
import org.slf4j.Logger
import org.slf4j.LoggerFactory


//TODO Add logger
/**
 * @args[0] is the discord API TOKEN.
 * @args[1] is the Database link.
 * @args[2] is the Database Username and Password separated by a space.
 */
fun main(args: Array<String>){
    val logger: Logger = LoggerFactory.getLogger("RedTrackerMain.main")
    Configurator.setRootLevel(Level.ALL)

    if(args.size < 3){
        logger.error("Missing args in the main function!\n" +
                "@args[0] is the discord API TOKEN.\n" +
                "@args[1] is the Database link.\n" +
                "@args[2] is the Database Username and Password separated by a space.")
        //return
    }
    //TODO Set Database
    //TODO Set Database Credentials

    JDABuilder.createLight(args[0],
        GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
        .addEventListeners(TextTaskManager())
        .build().awaitReady()

    logger.info("Red Tracker is ready to go!")

}
