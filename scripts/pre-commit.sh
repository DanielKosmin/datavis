#!/bin/sh

stagedFiles=$(git diff --staged --name-only)

# Run spotlessApply
echo "Running spotlessApply"
./gradlew spotlessApply
RESULT=$?  # Capture the exit status of spotlessApply

# Check if RESULT is not 0, which indicates an error
if [ $RESULT -ne 0 ]; then
    echo "spotlessApply failed."
    exit 1
fi

# Add modified files back to staging
for file in $stagedFiles; do
    if test -f "$file"; then
        git add "$file"
        echo "Added to staging: $file"
    fi
done

# Run Checkstyle
echo "Running Checkstyle"
./gradlew checkstyleMain checkstyleTest
CHECKSTYLE_RESULT=$?
if [ $CHECKSTYLE_RESULT -ne 0 ]; then
    echo "Checkstyle checks failed."
    exit 1
fi

# Run Unit Tests
echo "Running Unit Tests"
./gradlew unitTest
status=$?
if [ $status -ne 0 ]; then
    echo "Unit Tests failed."
    exit 1
fi

echo "Pre-commit checks passed."
exit 0