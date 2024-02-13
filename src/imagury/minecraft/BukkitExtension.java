package imagury.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

/**
 * Head interface for working with Minecraft Craftbukkit.
 * <dt><span class="strong">IMPORTANT INFORMATION</span></dt><dd>Using this interface requires Craftbukkit to be already included into the classpath!</dd>
 * @since JLight 0.3.0
 * @author Imagury 
 */
public interface BukkitExtension {

	final ConsoleCommandSender _sender = Bukkit.getConsoleSender();
	
	/**
	 * Head class for working with Server-side related functions with Craftbukkit.
	 * @since JLight 0.3.0
	 * @author Imagury 
	 *
	 */
	public class Server {

		/**
		 * Stops the Bukkit server.
		 * @since JLight 0.3.0
		 * @author Imagury 
		 */
		public static void stopServer() {
			Bukkit.dispatchCommand(_sender, "stop");
		}
		
		/**
		 * Executes a command from the Bukkit server console.
		 * @param command - Command to be executed
		 * @since JLight 0.3.0
		 * @author Imagury 
		 */
		public static void executeConsoleCommand(String command) {
			Bukkit.dispatchCommand(_sender, command);
		}
		
		/**
		 * Executes a command from a custom sender.
		 * @param command - Command to be executed
		 * @param sender - Specified sender to execute the command
		 * @since JLight 0.3.0
		 * @author Imagury 
		 */
		public static void executeConsoleCommand(CommandSender sender, String command) {
			Bukkit.dispatchCommand(sender, command);
		}
	}
}
