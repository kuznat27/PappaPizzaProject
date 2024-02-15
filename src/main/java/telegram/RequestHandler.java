package telegram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import static telegram.UserStatus.MENU;

public class RequestHandler {
    Map<Long, UserStatus> userStatusMap = new HashMap<>();
    List<KeyboardButton> mainMenu = List.of(new KeyboardButton("Order a pizza"), new KeyboardButton("Check order status"));

    public SendMessage handleTelegramRequest(Update update) {
        SendMessage sendMessage = null;
        Message message = update.getMessage();
        User user = message.getFrom();
        String receivedText = message.getText();

        if (userStatusMap.containsKey(user.getId())) {
            switch (userStatusMap.get(user.getId())) {
                case MENU:
                    sendMessage = handleMenuStatusRequest(user, receivedText);
                    break;
                case CHOOSING_A_PIZZA:
                    sendMessage = handleChoosingPizzaStatus(user, receivedText);
            }
        } else {
            sendMessage = handleInitialRequest(user);
        }

        return sendMessage;
    }

    private SendMessage handleInitialRequest(User user) {
        SendMessage sendMessage;
        userStatusMap.put(user.getId(), MENU);
        sendMessage = sendMenu(user.getId(), mainMenu, "Choose a menu option:");
        return sendMessage;
    }

    private SendMessage handleMenuStatusRequest(User user, String receivedText) {
        SendMessage sendMessage = null;
        if (receivedText.equals("Order a pizza")) {
            // Instead of sendText methods will be a specific logic
            userStatusMap.put(user.getId(), UserStatus.CHOOSING_A_PIZZA);
            sendMessage = sendMenu(user.getId(), List.of(new KeyboardButton("Pepperoni"), new KeyboardButton("Hawaiian")), "Choose an pizza:");
        } else if (receivedText.equals("Check order status")) {
            // Retrieve order for this user or all orders and present a choosing for our user
            userStatusMap.put(user.getId(), UserStatus.CHECKING_STATUS);
            sendMessage = sendMenu(user.getId(), List.of(new KeyboardButton("N123412"), new KeyboardButton("N512151")), "Choose an order:");
        }
        return sendMessage;
    }

    private SendMessage handleChoosingPizzaStatus(User user, String receivedText) {
        SendMessage sendMessage = null;
        userStatusMap.put(user.getId(), MENU);
        sendMessage = sendMenu(user.getId(), mainMenu, receivedText + "is chosen! Order is in process. Back to the main menu!");
        return sendMessage;
    }


    private SendMessage sendText(Long userId, String textToSend) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(textToSend);
        sendMessage.setChatId(userId.toString());

        return sendMessage;
    }

    private SendMessage sendMenu(Long userId, List<KeyboardButton> keyboardButtons, String textToSend) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(new KeyboardRow(keyboardButtons));

        keyboardMarkup.setKeyboard(keyboard);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(textToSend);
        sendMessage.setReplyMarkup(keyboardMarkup);
        sendMessage.setChatId(userId.toString());

        return sendMessage;
    }
}
