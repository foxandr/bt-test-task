package test.converters;

import test.models.OperationType;

import javax.persistence.AttributeConverter;
import java.util.Optional;
import java.util.stream.Stream;

public class OperationTypeConverter implements AttributeConverter<OperationType, String> {

    @Override
    public String convertToDatabaseColumn(OperationType attribute) {
        return Optional.ofNullable(attribute)
                .map(OperationType::getName)
                .orElse(null);
    }

    @Override
    public OperationType convertToEntityAttribute(String dbData) {
        return Stream.of(OperationType.values())
                .filter(operationType -> operationType.getName().equals(dbData))
                .findFirst()
                .orElse(null);
    }
}
