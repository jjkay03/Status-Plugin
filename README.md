# Status Plugin

[<img alt="modrinth" height="40" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/available/modrinth_46h.png">](https://modrinth.com/plugin/status-plugin)

A Bukkit server plugin that allows you to set a status.

This plugin is a recreation of the [Status Mod](https://github.com/henkelmax/status) (Fabric) by [henkelmax](https://github.com/henkelmax), used on the Hermitcraft server but for Bukkit servers.

<br>

# Features

By using `/status` you will be able to interact with the status menu and set a status.

The status consist of two parts, as you can see in the images bellow.
- On the left side the **AVAILIBLITY** status (Open, Do Not Disturbe).
- On the right side the **MEDIA** status (Recording, Streaming).

<img src="https://github.com/user-attachments/assets/a336647f-e6b8-42d1-be8a-f761b2c7048f" width="700">

### The status color icons will show up next to the players head in the tab list.

<img src="https://github.com/user-attachments/assets/65ac5afd-28d0-4d12-a80b-1e9e8e272f96" width="700">

### All statuses:

<img src="https://github.com/user-attachments/assets/a0e33a8c-3ada-4483-9a22-8e0cddbcbf17" width="400">

### Seting status reminder on join.

<img src="https://github.com/user-attachments/assets/fca4d915-6baa-4243-8401-00cc606452a3" width="600">

<br>
<br>

# Config

Some features can be modified or toggled on and off iside of the config file.
`.../plugins/StatusPlugin/config.yml`

| Key                         | Default Value                                         | Description                                                                 |
|------------------------------|------------------------------------------------------|-----------------------------------------------------------------------------|
| `enable-join-message-reminder` | `true`                                               | Whether to show a reminder message when the player joins the server.       |
| `join-message-reminder`        | `"§7Don't forget to set your status using §e/status §7!"` | The message shown when a player joins, reminding them to set their status. |
| `enable-media-alerts`         | `true`                                               | Whether to alert players when someone starts recording or streaming.       |
| `media-alert-record`          | `"§7%player% is recording!"`                         | Message displayed when a player starts recording.                           |
| `media-alert-stream`          | `"§7%player% is streaming!"`                         | Message displayed when a player starts streaming.                           |
| `enable-tab-server-name`      | `false`                                              | Whether to show a custom server name in the tab list.                       |
| `tab-server-name`             | `"§e§lSERVER NAME"`                                  | The server name displayed in the tab list, using formatting codes.          |


