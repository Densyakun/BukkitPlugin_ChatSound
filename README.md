# BukkitPlugin_ChatSound
This plugin is sound play by send chat. チャットを送信すると音がなるBukkitプラグインです。

# 使い方
* プラグインのJarをpluginsフォルダに入れます。
* サーバーを起動し、プラグインが読み込まれると、pluginsフォルダ内にChatSoundフォルダが作成されます。
* ChatSoundフォルダ内にあるconfig.ymlを編集します。Sound欄にサウンド名を入力します（例: minecraft:block.note_block.harp の場合→ "BLOCK_NOTE_BLOCK_HARP"）。Volumeは音量で、通常は1.0です。Pitchは音程（再生速度）で、0.0~2.0の範囲で入力してください。
* reloadコマンドなどを用いて、サーバーを再起動すると、設定が反映されます。
* チャットを送信すると、全プレイヤーに対して音がなります。
