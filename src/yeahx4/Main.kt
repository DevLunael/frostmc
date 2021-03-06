package yeahx4

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import yeahx4.command.Plugin
import yeahx4.command.claim.DailyClaim
import yeahx4.command.trigger.*
import yeahx4.event.OnPlayerMove

class Main: JavaPlugin() {
    public override fun onLoad() {
        println("Loading YEAHx4 plugin")
    }

    public override fun onEnable() {
        getCommand("plugin")?.setExecutor(Plugin())
        getCommand("plugin")?.tabCompleter = Plugin()

        getCommand("areatrigger")?.setExecutor(AreaTrigger())
        getCommand("areatrigger")?.tabCompleter = AreaTriggerTabCompletion()

        getCommand("gettrigger")?.setExecutor(GetTrigger())
        getCommand("gettrigger")?.tabCompleter = GetTriggerTabCompletion()

        getCommand("reloadtrigger")?.setExecutor(ReloadTrigger())
        getCommand("reloadtrigger")?.tabCompleter = ReloadTrigger()

        getCommand("claim")?.setExecutor(DailyClaim())
        getCommand("claim")?.tabCompleter = DailyClaim()

        server.pluginManager.registerEvents(OnPlayerMove(), this)

        reload(Bukkit.getConsoleSender())
        println("YEAHx4 plugin enabled")
    }

    public override fun onDisable() {
        println("YEAHx4 plugin disabled")
    }
}