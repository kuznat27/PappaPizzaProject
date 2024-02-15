package telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class telegramBot extends TelegramLongPollingBot {
    RequestHandler requestHandler = new RequestHandler();

    @Override
    public String getBotToken() {
        return "6839949564:AAGV2b0m2Zm1-M4v5okQG_YfIowYiPznaXY";
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = requestHandler.handleTelegramRequest(update);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "pizzaOrderingHungaryBot";
    }
}
