package ru.artemiyandarina.blps_lab1.enums;

public enum PetitionTopic {
    ОКРУЖАЮЩАЯ_СРЕДА,
    СОЦИАЛЬНАЯ_СПРАВЕДЛИВОСТЬ,
    ЗДРАВООХРАНЕНИЕ,
    ОБРАЗОВАНИЕ,
    ПРАВА_ЖИВОТНЫХ,
    ПРАВА_ЧЕЛОВЕКА,
    ЭКОНОМИЧЕСКИЕ_РЕФОРМЫ,
    ТЕХНОЛОГИИ,
    ПОЛИТИКА,
    РАЗВИТИЕ_СООБЩЕСТВА;

    public static PetitionTopic valueOfIgnoreCase(String topicName) {
        for (PetitionTopic topic : values()) {
            if (topic.name().equalsIgnoreCase(topicName)) {
                return topic;
            }
        }
        throw new IllegalArgumentException("No enum constant " + PetitionTopic.class.getName() + " with name " + topicName);
    }
}
